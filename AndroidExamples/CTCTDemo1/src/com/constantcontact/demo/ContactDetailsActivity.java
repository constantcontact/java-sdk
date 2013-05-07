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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.constantcontact.components.contacts.Address;
import com.constantcontact.components.contacts.Contact;
import com.constantcontact.components.contacts.ContactList;
import com.constantcontact.components.contacts.CustomField;
import com.constantcontact.components.contacts.EmailAddress;
import com.constantcontact.components.contacts.Note;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.util.CUrlRequestError;

public class ContactDetailsActivity extends Activity implements View.OnClickListener {

	private static final String LOG_TAG = "CTCT";

	private static final String CONTACT_DETAILS_KEY = "CONTACT_DETAILS";
	private static final String SELECTED_LISTS_KEY = "SELECTED_LISTS";
	private static final String ADDRESS_KEY = "ADDRESS";
	private static final String CUSTOM_FIELDS_KEY = "CUSTOM_FIELDS";
	private static final String ADD_NEW_CONTACT_KEY = "ADD_NEW_CONTACT";

	// requestCodes for activity results
	private static final int SELECT_LISTS_CODE = 1;
	private static final int ADDRESS_CODE = 2;
	private static final int CUSTOM_FIELDS_CODE = 3;

	private EditText txtContactId;
	private EditText txtStatus;
	private EditText txtFirstName;
	private EditText txtLastName;
	private EditText txtMiddleName;
	private EditText txtModifiedDate;
	private EditText txtSourceDetails;
	private EditText txtWorkPhone;
	private EditText txtCellPhone;
	private EditText txtHomePhone;
	private EditText txtFax;
	private EditText txtPrefix;
	private EditText txtJobTitle;
	private EditText txtCompanyName;
	private EditText txtEmailAddress1;
	private EditText txtEmailAddress2;
	private EditText txtEmailAddress3;
	private EditText txtAddress;
	private EditText txtCustomFields;
	private EditText txtLists;
	private EditText txtNotes;

	private Button btnUpdate;

	private String addNewContact;
	Contact contact;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_details);

		// initialize UI controls
		txtContactId = (EditText) findViewById(R.id.txtContactId);
		txtStatus = (EditText) findViewById(R.id.txtStatus);
		txtFirstName = (EditText) findViewById(R.id.txtFirstName);
		txtLastName = (EditText) findViewById(R.id.txtLastName);
		txtMiddleName = (EditText) findViewById(R.id.txtMiddleName);
		txtModifiedDate = (EditText) findViewById(R.id.txtModifiedDate);
		txtSourceDetails = (EditText) findViewById(R.id.txtSourceDetails);
		txtWorkPhone = (EditText) findViewById(R.id.txtWorkPhone);
		txtCellPhone = (EditText) findViewById(R.id.txtCellPhone);
		txtHomePhone = (EditText) findViewById(R.id.txtHomePhone);
		txtFax = (EditText) findViewById(R.id.txtFax);
		txtPrefix = (EditText) findViewById(R.id.txtPrefix);
		txtJobTitle = (EditText) findViewById(R.id.txtJobTitle);
		txtCompanyName = (EditText) findViewById(R.id.txtCompanyName);
		txtEmailAddress1 = (EditText) findViewById(R.id.txtEmailAddress1);
		txtEmailAddress2 = (EditText) findViewById(R.id.txtEmailAddress2);
		txtEmailAddress3 = (EditText) findViewById(R.id.txtEmailAddress3);
		txtAddress = (EditText) findViewById(R.id.txtAddress);
		txtCustomFields = (EditText) findViewById(R.id.txtCustomFields);
		txtLists = (EditText) findViewById(R.id.txtLists);
		txtNotes = (EditText) findViewById(R.id.txtNotes);

		btnUpdate = (Button) findViewById(R.id.btnUpdate);

		txtAddress.setFocusable(false);
		txtAddress.setClickable(true);
		txtAddress.setOnClickListener(this);

		txtCustomFields.setFocusable(false);
		txtCustomFields.setClickable(true);
		txtCustomFields.setOnClickListener(this);

		txtLists.setFocusable(false);
		txtLists.setClickable(true);
		txtLists.setOnClickListener(this);

		btnUpdate.setOnClickListener(this);


		// initialize contact object
		contact = new Contact();
		contact.setAddresses(new ArrayList<Address>());
		contact.setEmailAddresses(new ArrayList<EmailAddress>());
		contact.setCustomFields(new ArrayList<CustomField>());
		contact.setLists(new ArrayList<ContactList>());
		

		Bundle extras = getIntent().getExtras();
		String contactId = extras.getString(CONTACT_DETAILS_KEY);
		addNewContact = extras.getString(ADD_NEW_CONTACT_KEY);

		if (contactId != null) {
			setTitle("Update Contact");
			getContactDetails(contactId);
		}

		if (addNewContact != null) {
			setTitle("Add new contact");
			btnUpdate.setText(getString(R.string.kLblAdd));
			txtEmailAddress1.setText(addNewContact);
		}
	}

	@Override
	public void onClick(View v) {
		Bundle bundle = new Bundle();
		Intent intent = null;

		switch (v.getId()) {
		
		case R.id.txtLists:
			List<String> tempList = new ArrayList<String>();
			for (ContactList contactList : contact.getLists())
				tempList.add(contactList.getId());

			bundle.putStringArray(SELECTED_LISTS_KEY, tempList.toArray(new String[] {}));

			intent = new Intent(ContactDetailsActivity.this, ContactListsActivity.class);
			intent.putExtras(bundle);

			startActivityForResult(intent, SELECT_LISTS_CODE);
			break;
			
		case R.id.txtAddress:
			if (contact.getAddresses().size() > 0)
				bundle.putSerializable(ADDRESS_KEY, contact.getAddresses().get(0));

			intent = new Intent(ContactDetailsActivity.this, ContactAddressActivity.class);
			intent.putExtras(bundle);

			startActivityForResult(intent, ADDRESS_CODE);
			break;

		case R.id.txtCustomFields:
			bundle.putSerializable(CUSTOM_FIELDS_KEY, (ArrayList<CustomField>) contact.getCustomFields());

			intent = new Intent(ContactDetailsActivity.this, ContactCustomFieldsActivity.class);
			intent.putExtras(bundle);

			startActivityForResult(intent, CUSTOM_FIELDS_CODE);
			break;
			
		case R.id.btnUpdate:
			if(isValidData()) {
				updateContactData();
				updateContact(contact);
			} else {
				new AlertDialog.Builder(ContactDetailsActivity.this).setTitle("Error").setMessage("List cannot be empty.").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

					}
				}).show();				
			}
			break;
		}
	}

	private boolean isValidData() {
		if(txtLists.getText().length() == 0)
			return false;
		else
			return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK) {
			if (requestCode == SELECT_LISTS_CODE) {
				txtLists.setText("");

				List<ContactList> contactLists = new ArrayList<ContactList>();

				String[] selectedListsIds = data.getStringArrayExtra(SELECTED_LISTS_KEY);
				if (selectedListsIds != null) {
					for (String id : selectedListsIds) {
						// update text field
						txtLists.setText(String.format("%s %s,", txtLists.getText(), id));

						// update contact data
						ContactList contactList = new ContactList();
						contactList.setId(id);
						
						contactLists.add(contactList);
					}
				}
				
				//update contact lists
				contact.setLists(contactLists);

			} else if (requestCode == ADDRESS_CODE) {

				com.constantcontact.components.contacts.Address address = (com.constantcontact.components.contacts.Address) data.getSerializableExtra(ADDRESS_KEY);
				// update text field
				txtAddress.setText(String.format("%s, %s, %s, %s, %s", address.getLine1(), address.getLine2(), address.getLine3(), address.getCity(), address.getStateCode()));

				// update contact address
				contact.getAddresses().clear();
				contact.getAddresses().add(address);

			} else if (requestCode == CUSTOM_FIELDS_CODE) {

				// update text field
				txtCustomFields.setText("");

				// update text field
				contact.setCustomFields((List<CustomField>) data.getSerializableExtra(CUSTOM_FIELDS_KEY));
				for (com.constantcontact.components.contacts.CustomField customField : contact.getCustomFields()) {
					txtCustomFields.setText(String.format("%s %s, ", txtCustomFields.getText(), customField.getValue()));
				}
				
				// update contact customFields list
				contact.setCustomFields((List<CustomField>) data.getSerializableExtra(CUSTOM_FIELDS_KEY));

			}
		}
	}

	private void getContactDetails(final String contactId) {
		new AsyncTask<Void, Void, Contact>() {
			
			//custom exception that holds the list of errors received from server
			private ConstantContactServiceException mError;
			
			private ProgressDialog mProgressDialog;

			@Override
			protected void onPreExecute() {
				mProgressDialog = ProgressDialog.show(ContactDetailsActivity.this, null, getString(R.string.kMsgLoading), true, false);
			}

			@Override
			protected Contact doInBackground(Void... voids) {
				try {
					return GlobalConfig.getInstance().getConstantContactService().getContact(contactId);
				} catch (ConstantContactServiceException e) {
					mError = e;
				}

				return null;
			}

			@Override
			protected void onPostExecute(Contact contactResponse) {
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

					new AlertDialog.Builder(ContactDetailsActivity.this).setTitle("Server Error").setMessage(errorMessage).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

						}
					}).show();
					return;
				}
				
				contact = contactResponse;
				updateUserInterface(contact);
			}

		}.execute();
	}

	private void updateContact(final Contact contact) {
		new AsyncTask<Void, Void, Contact>() {

			private ConstantContactServiceException mError;
			private ProgressDialog mProgressDialog;

			@Override
			protected void onPreExecute() {
				mProgressDialog = ProgressDialog.show(ContactDetailsActivity.this, null, getString(R.string.kMsgLoading), true, false);
			}

			@Override
			protected Contact doInBackground(Void... voids) {
				try {
					if (addNewContact == null)
						return GlobalConfig.getInstance().getConstantContactService().updateContact(contact);

					return GlobalConfig.getInstance().getConstantContactService().addContact(contact);

				} catch (ConstantContactServiceException e) {
					Log.w(LOG_TAG, e.getErrorInfo().toString());
					mError = e;
				}

				return null;
			}

			@Override
			protected void onPostExecute(final Contact contact) {
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

					new AlertDialog.Builder(ContactDetailsActivity.this).setTitle("Server Error").setMessage(errorMessage).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

						}
					}).show();
					return;
				}

				new AlertDialog.Builder(ContactDetailsActivity.this).setTitle("Message").setMessage("Contact updated!").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						updateUserInterface(contact);
					}
				}).show();

			}
		}.execute();
	}

	protected void updateContactData() {

		if (addNewContact != null)
			contact.setId(null);
		else
			contact.setId(txtContactId.getText().toString());

		contact.setFirstName(txtFirstName.getText().toString());
		contact.setLastName(txtLastName.getText().toString());
		contact.setMiddleName(txtMiddleName.getText().toString());

		contact.setSourceDetails(txtSourceDetails.getText().toString());

		contact.setCellPhone(txtCellPhone.getText().toString());
		contact.setHomePhone(txtHomePhone.getText().toString());
		contact.setFax(txtFax.getText().toString());
		contact.setPrefixName(txtPrefix.getText().toString());

		contact.setJobTitle(txtJobTitle.getText().toString());
		contact.setCompanyName(txtCompanyName.getText().toString());
		contact.setWorkPhone(txtWorkPhone.getText().toString());

		List<EmailAddress> emailAddrList = new ArrayList<EmailAddress>();

		EmailAddress address = new EmailAddress();
		
		address.setEmailAddress(txtEmailAddress1.getText().toString());
		emailAddrList.add(address);
		
		//currently not supported server side
//		address.setEmailAddress(txtEmailAddress2.getText().toString());
//		emailAddrList.add(address);
//		
//		address.setEmailAddress(txtEmailAddress3.getText().toString());
//		emailAddrList.add(address);
		
		contact.setEmailAddresses(emailAddrList);

		Note note = new Note();
		note.setNote(txtNotes.getText().toString());

		contact.getNotes().clear();
		contact.getNotes().add(note);

	}

	private void updateUserInterface(Contact contact) {

		clearAllData();

		txtContactId.setText(contact.getId());
		txtStatus.setText(contact.getStatus());
		txtFirstName.setText(contact.getFirstName());
		txtLastName.setText(contact.getLastName());
		txtMiddleName.setText(contact.getMiddleName());
		txtModifiedDate.setText(contact.getModifiedDate());
		txtSourceDetails.setText(contact.getSourceDetails());
		txtWorkPhone.setText(contact.getWorkPhone());
		txtCellPhone.setText(contact.getCellPhone());
		txtHomePhone.setText(contact.getHomePhone());
		txtFax.setText(contact.getFax());
		txtPrefix.setText(contact.getPrefixName());
		txtJobTitle.setText(contact.getJobTitle());
		txtCompanyName.setText(contact.getCompanyName());

		int emailCount = contact.getEmailAddresses().size();
		txtEmailAddress1.setText(contact.getEmailAddresses().get(0).getEmailAddress());
		if (emailCount >= 2)
			txtEmailAddress2.setText(contact.getEmailAddresses().get(1).getEmailAddress());
		if (emailCount == 3)
			txtEmailAddress3.setText(contact.getEmailAddresses().get(2).getEmailAddress());

		com.constantcontact.components.contacts.Address address = contact.getAddresses().get(0);
		txtAddress.setText(String.format("%s, %s, %s, %s, %s", address.getLine1(), address.getLine2(), address.getLine3(), address.getCity(), address.getStateCode()));

		for (com.constantcontact.components.contacts.CustomField customField : contact.getCustomFields()) {
			txtCustomFields.setText(String.format("%s %s, ", txtCustomFields.getText(), customField.getValue()));
		}

		for (ContactList contactList : contact.getLists()) {
			txtLists.setText(String.format("%s %s, ", txtLists.getText(), contactList.getId()));
		}

		for (Note note : contact.getNotes()) {
			txtNotes.setText(String.format("%s %s, ", txtNotes.getText(), note.getNote()));
		}

		// if we added a contact we're switching to update mode
		if (addNewContact != null) {
			addNewContact = null;
			btnUpdate.setText(getString(R.string.kLblUpdate));
			setTitle("Update contact");
		}
	}

	private void clearAllData() {

		TableLayout table = (TableLayout) findViewById(R.id.tblContactDetails);

		for (int i = 0; i < table.getChildCount(); i++) {
			TableRow row = (TableRow) table.getChildAt(i);
			for (int j = 0; j < row.getChildCount(); j++)
				if (row.getChildAt(j) instanceof EditText)
					((EditText) row.getChildAt(j)).setText("");
		}

	}

}
