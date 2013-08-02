package com.constantcontact.demo2;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.constantcontact.ConstantContact;
import com.constantcontact.components.accounts.VerifiedEmailAddress;
import com.constantcontact.components.emailcampaigns.EmailCampaignBase.EmailContentFormat;
import com.constantcontact.components.emailcampaigns.EmailCampaignBase.GreetingName;
import com.constantcontact.components.emailcampaigns.EmailCampaignRequest;
import com.constantcontact.components.emailcampaigns.EmailCampaignResponse;
import com.constantcontact.components.emailcampaigns.MessageFooter;
import com.constantcontact.components.emailcampaigns.SentToContactList;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.util.CUrlRequestError;

public class EmailCampaignActivity extends Activity implements View.OnClickListener{

	private static final String LOG_TAG = "CTCT";
	
	private static final String SELECTED_LISTS_KEY = "SELECTED_LISTS";
	private static final String SCHEDULE_CAMPAIGN_KEY = "SCHEDULE_CAMPAIGN";
	
	
	// requestCodes for activity results
	private static final int SELECT_LISTS_CODE = 1;
	private static final int SCHEDULE_CAMPAIGN_CODE = 2;
	
	private EditText txtCampaignName;
	private EditText txtSubject;
	private EditText txtFromName;
	private EditText txtFromEmailAddress;
	private EditText txtReplyEmailAddress;
	private EditText txtSendToLists;
	private EditText txtEmailContent;
	private EditText txtTextContent;
	private EditText txtOrganizationName;
	private EditText txtAddress1;
	private EditText txtAddress2;
	private EditText txtAddress3;
	private EditText txtCity;
	private EditText txtState;
	private EditText txtPostalCode;
	private EditText txtCountry;

	Button btnSave;

	EmailCampaignRequest emailCampaignRequest;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_email_campaign);
		setTitle(R.string.kLblEmailCampaignTitle);
		
		emailCampaignRequest = new EmailCampaignRequest();
		emailCampaignRequest.setSentToContactLists(new ArrayList<SentToContactList>());

		txtCampaignName = (EditText) findViewById(R.id.txtCampaignName);
		txtSubject = (EditText) findViewById(R.id.txtSubject);
		txtFromName = (EditText) findViewById(R.id.txtFromName);
		txtFromEmailAddress = (EditText) findViewById(R.id.txtFromEmailAddress);
		txtReplyEmailAddress = (EditText) findViewById(R.id.txtReplyEmailAddress);
		txtSendToLists = (EditText) findViewById(R.id.txtSendToLists);
		txtEmailContent = (EditText) findViewById(R.id.txtEmailContent);
		txtTextContent = (EditText) findViewById(R.id.txtTextContent);
		txtOrganizationName = (EditText) findViewById(R.id.txtOrganizationName);
		txtAddress1 = (EditText) findViewById(R.id.txtAddress1);
		txtAddress2 = (EditText) findViewById(R.id.txtAddress2);
		txtAddress3 = (EditText) findViewById(R.id.txtAddress3);
		txtCity = (EditText) findViewById(R.id.txtCity);
		txtState = (EditText) findViewById(R.id.txtState);
		txtPostalCode = (EditText) findViewById(R.id.txtPostalCode);
		txtCountry = (EditText) findViewById(R.id.txtCountry);

		btnSave = (Button) findViewById(R.id.btnSave);
		btnSave.setOnClickListener(this);
		
		txtSendToLists.setFocusable(false);
		txtSendToLists.setClickable(true);
		txtSendToLists.setOnClickListener(this);
		
		
		txtEmailContent.setText("<html><body></body></html>");
		
		GlobalConfig.getInstance().setConstantContactService(new ConstantContact(getString(R.string.API_KEY), GlobalConfig.getInstance().getAccessToken()));
		getVerifiedEmailAddress();
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK) {
			if (requestCode == SELECT_LISTS_CODE) {
				txtSendToLists.setText("");

				List<SentToContactList> contactLists = new ArrayList<SentToContactList>();

				String[] selectedListsIds = data.getStringArrayExtra(SELECTED_LISTS_KEY);
				if (selectedListsIds != null) {
					for (String id : selectedListsIds) {
						// update text field
						txtSendToLists.setText(String.format("%s %s,", txtSendToLists.getText(), id));

						// update contact data
						SentToContactList contactList = new SentToContactList(id);
						contactLists.add(contactList);
					}
				}

				// update contact lists
				emailCampaignRequest.setSentToContactLists(contactLists);

			} else if(requestCode == SCHEDULE_CAMPAIGN_CODE) {
				clearUIData();
				emailCampaignRequest = new EmailCampaignRequest();
				emailCampaignRequest.setSentToContactLists(new ArrayList<SentToContactList>());
			}
			
		}
	}

	private void clearUIData() {
		txtCampaignName.setText("");
		txtSubject.setText("");
		txtFromName.setText("");
		txtSendToLists.setText("");
		txtTextContent.setText("");
		txtOrganizationName.setText("");
		txtAddress1.setText("");
		txtAddress2.setText("");
		txtAddress3.setText("");
		txtCity.setText("");
		txtState.setText("");
		txtPostalCode.setText("");
		txtCountry.setText("");
	}

	@Override
	public void onClick(View v) {
		Bundle bundle = new Bundle();
		Intent intent = null;

		switch (v.getId()) {

		case R.id.txtSendToLists:
			List<String> tempList = new ArrayList<String>();
			for (SentToContactList contactList : emailCampaignRequest.getSentToContactLists())
				tempList.add(contactList.getId());

			bundle.putStringArray(SELECTED_LISTS_KEY, tempList.toArray(new String[] {}));

			intent = new Intent(EmailCampaignActivity.this, ContactListsActivity.class);
			intent.putExtras(bundle);

			startActivityForResult(intent, SELECT_LISTS_CODE);
			break;
		case R.id.btnSave:
			updateEmailCampaignInfo();
			addCampaign();
			break;
		}
	}
	
	private void updateEmailCampaignInfo() {
		
		emailCampaignRequest.setName(txtCampaignName.getText().toString());
		emailCampaignRequest.setSubject(txtSubject.getText().toString());
		emailCampaignRequest.setFromEmail(txtFromEmailAddress.getText().toString());
		emailCampaignRequest.setFromName(txtFromName.getText().toString());
		emailCampaignRequest.setReplyToEmail(txtReplyEmailAddress.getText().toString());
		emailCampaignRequest.setPermissionReminderEnabled(true);
		emailCampaignRequest.setPermissionReminderText("As a reminder, you're receiving this email because you have expressed an interest in MyCompany.");
		emailCampaignRequest.setViewAsWebpageEnabled(true);
		emailCampaignRequest.setViewAsWebPageLinkText("Click test here");
		emailCampaignRequest.setViewAsWebPageText("View this message as a web page");
		emailCampaignRequest.setGreetingSalutations("Greetingss");
		emailCampaignRequest.setGreetingName(GreetingName.FIRST_AND_LAST_NAME);
		emailCampaignRequest.setGreetingString("Dear...");
		emailCampaignRequest.setEmailContent(txtEmailContent.getText().toString());
		emailCampaignRequest.setTextContent(txtTextContent.getText().toString());
		emailCampaignRequest.setEmailContentFormat(EmailContentFormat.HTML);

		MessageFooter footer = new MessageFooter();
		footer.setOrganizationName(txtOrganizationName.getText().toString());
		footer.setAddressLine1(txtAddress1.getText().toString());
		footer.setAddressLine2(txtAddress2.getText().toString());
		footer.setAddressLine3(txtAddress3.getText().toString());
		footer.setCity(txtCity.getText().toString());
		footer.setPostalCode(txtPostalCode.getText().toString());
		footer.setState(txtState.getText().toString());
		footer.setCountry(txtCountry.getText().toString());
		footer.setIncludeForwardEmail(true);
		footer.setForwardEmailLinkText("Click here to forward");
		footer.setIncludeSubscribeLink(true);
		footer.setSubscribeLinkText("Subscribe OSF here");
		emailCampaignRequest.setMessageFooter(footer);
		
	}

	private void getVerifiedEmailAddress() {
		new AsyncTask<Void, Void, List<VerifiedEmailAddress>>() {
			
			//custom exception that holds the list of errors received from server
			private ConstantContactServiceException mError;
			
			private ProgressDialog mProgressDialog;

			@Override
			protected void onPreExecute() {
				mProgressDialog = ProgressDialog.show(EmailCampaignActivity.this, null, getString(R.string.kMsgLoading), true, false);
			}

			@Override
			protected List<VerifiedEmailAddress> doInBackground(Void... voids) {
				try {
					return GlobalConfig.getInstance().getConstantContactService().getVerifiedEmailAddresses(VerifiedEmailAddress.Status.CONFIRMED);
				} catch (ConstantContactServiceException e) {
					mError = e;
				}

				return null;
			}

			@Override
			protected void onPostExecute(List<VerifiedEmailAddress> emailList) {
				try {
					mProgressDialog.dismiss();
				} catch (Throwable t) {
					Log.e(LOG_TAG, t.getMessage(), t);
				}

				// handle errors from server
				if (mError != null) {
					Log.e(LOG_TAG, mError.getErrorInfo().toString(), mError);
					
					String errorMessage = new String();
					for (CUrlRequestError error : mError.getErrorInfo())
						errorMessage += error.getErrorMessage() + "\n";

					new AlertDialog.Builder(EmailCampaignActivity.this).setTitle("Server Error").setMessage(errorMessage).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

						}
					}).show();
					return;
				}
				
				if(emailList.size() > 0) {
					txtFromEmailAddress.setText(emailList.get(0).getEmailAddress());
					txtReplyEmailAddress.setText(emailList.get(0).getEmailAddress());
				}
			}
			

		}.execute();
	}
	
	private void addCampaign() {
		new AsyncTask<Void, Void, EmailCampaignResponse>() {
			
			//custom exception that holds the list of errors received from server
			private ConstantContactServiceException mError;
			
			private ProgressDialog mProgressDialog;

			@Override
			protected void onPreExecute() {
				mProgressDialog = ProgressDialog.show(EmailCampaignActivity.this, null, getString(R.string.kMsgLoading), true, false);
			}

			@Override
			protected EmailCampaignResponse doInBackground(Void... voids) {
				try {
					Log.e(LOG_TAG, emailCampaignRequest.getSentToContactLists().toString());
					return GlobalConfig.getInstance().getConstantContactService().addEmailCampaign(emailCampaignRequest);
				} catch (ConstantContactServiceException e) {
					mError = e;
				}

				return null;
			}

			@Override
			protected void onPostExecute(final EmailCampaignResponse emailCampaignResponse) {
				try {
					mProgressDialog.dismiss();
				} catch (Throwable t) {
					Log.e(LOG_TAG, t.getMessage(), t);
				}

				// handle errors from server
				if (mError != null) {
					Log.e(LOG_TAG, mError.getErrorInfo().toString(), mError);
					
					String errorMessage = new String();
					for (CUrlRequestError error : mError.getErrorInfo())
						errorMessage += error.getErrorMessage() + "\n";

					new AlertDialog.Builder(EmailCampaignActivity.this).setTitle("Server Error").setMessage(errorMessage).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

						}
					}).show();
					return;
				}
				new AlertDialog.Builder(EmailCampaignActivity.this).setTitle("Info").setMessage("Email Campaign added!").setPositiveButton("Ok", new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						Bundle bundle = new Bundle();
						
						Intent intent = new Intent(EmailCampaignActivity.this, ScheduleActivity.class);
						
						bundle.putString(SCHEDULE_CAMPAIGN_KEY, emailCampaignResponse.getId());
						intent.putExtras(bundle);
						
						Log.e(LOG_TAG, emailCampaignResponse.getId());
						Log.e(LOG_TAG, emailCampaignResponse.getSentToContactLists().toString());
						startActivityForResult(intent, SCHEDULE_CAMPAIGN_CODE);
					}
				}).show();
				
			}

		}.execute();
	}

}
