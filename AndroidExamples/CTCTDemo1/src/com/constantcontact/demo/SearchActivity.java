package com.constantcontact.demo;

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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.constantcontact.ConstantContact;
import com.constantcontact.components.contacts.Contact;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.util.CUrlRequestError;

public class SearchActivity extends Activity {

	private static final String LOG_TAG = "CTCT";
	private static final String ADD_NEW_CONTACT = "Add new contact";

	private static final String CONTACT_DETAILS_KEY = "CONTACT_DETAILS";
	private static final String ADD_NEW_CONTACT_KEY = "ADD_NEW_CONTACT";

	ListView lstSearchResults;
	List<Item> itemList;

	Button btnSearch;
	TextView txtEmailAddress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		setTitle("Search contact");

		lstSearchResults = (ListView) findViewById(R.id.lstResults);
		lstSearchResults.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				String contactId = itemList.get(arg2).getId();
				String displayText = itemList.get(arg2).getDiplayText();

				Bundle bundle = new Bundle();
				if (displayText.compareTo(ADD_NEW_CONTACT) != 0) {
					bundle.putString(CONTACT_DETAILS_KEY, contactId);
				} else {
					bundle.putString(ADD_NEW_CONTACT_KEY, txtEmailAddress.getText().toString());
				}

				Intent intent = new Intent(SearchActivity.this, ContactDetailsActivity.class);
				intent.putExtras(bundle);

				startActivity(intent);
			}
		});

		txtEmailAddress = (TextView) findViewById(R.id.txtEmailAddress);
		
		btnSearch = (Button) findViewById(R.id.btnSearch);
		btnSearch.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				txtEmailAddress.clearFocus();
				getContactByEmail();
			}
		});
		
		//initialize the constant contact service
		GlobalConfig.getInstance().setConstantContactService(new ConstantContact(getString(R.string.API_KEY), GlobalConfig.getInstance().getAccessToken()));

	}

	private void getContactByEmail() {
		new AsyncTask<Void, Void, ResultSet<Contact>>() {
			
			//custom exception that holds the list of errors received from server
			private ConstantContactServiceException mError;
			
			private ProgressDialog mProgressDialog;

			@Override
			protected void onPreExecute() {
				mProgressDialog = ProgressDialog.show(SearchActivity.this, null, getString(R.string.kMsgLoading), true, false);
			}

			@Override
			protected ResultSet<Contact> doInBackground(Void... voids) {
				try {
					Log.w(LOG_TAG, btnSearch.getText().toString());
					return GlobalConfig.getInstance().getConstantContactService().getContactByEmail(txtEmailAddress.getText().toString());

				} catch (ConstantContactServiceException e) {
					mError = e;
				}

				return null;
			}

			@Override
			protected void onPostExecute(ResultSet<Contact> response) {
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

					new AlertDialog.Builder(SearchActivity.this).setTitle("Server Error").setMessage(errorMessage).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

						}
					}).show();
					return;
				}
				
				itemList = new ArrayList<Item>();
				for (Contact contact : response.getResults()) {

					Item item = new Item();
					item.setDiplayText(String.format("%s %s %s", contact.getFirstName(), contact.getLastName(), contact.getEmailAddresses().get(0).getEmailAddress()));
					item.setId(contact.getId());

					itemList.add(item);
				}
				
				//if there is no search results we add a new one
				if (itemList.size() == 0) {
					Item item = new Item();
					item.setDiplayText(ADD_NEW_CONTACT);
					item.setId(txtEmailAddress.getText().toString());

					itemList.add(item);
				}
				
				ArrayAdapter<Item> contactListAdapter = new ArrayAdapter<Item>(getBaseContext(), android.R.layout.simple_list_item_1, (Item[]) itemList.toArray(new Item[] {}));
				lstSearchResults.setAdapter(contactListAdapter);
			}
		}.execute();
	}

	@Override
	public void onBackPressed() {

		new AlertDialog.Builder(SearchActivity.this).setTitle("Message").setMessage("Do you really want to quit?")
		.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				finish();
			}
		}).setNegativeButton("No", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				return;
			}
		}).show();
	}

}
