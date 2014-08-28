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
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.constantcontact.components.contacts.ContactList;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.util.CUrlRequestError;

public class ContactListsActivity extends Activity {

	private static final String LOG_TAG = "CTCT";
	private static final String SELECTED_LISTS_KEY = "SELECTED_LISTS";

	ListView lstContactLists;
	List<Item> itemList;

	Button btnSave;

	private String[] initialSelectedListsIds;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_lists);

		Bundle extras = getIntent().getExtras();
		initialSelectedListsIds = extras.getStringArray(SELECTED_LISTS_KEY);

		lstContactLists = (ListView) findViewById(R.id.lstContactLists);
		btnSave = (Button) findViewById(R.id.btnSave);
		btnSave.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				//update the selected list ids
				List<String> selectedListsIds = new ArrayList<String>();
				SparseBooleanArray checkedItems = lstContactLists.getCheckedItemPositions();
				int count = checkedItems.size();
				for (int i = 0; i < count; i++) {
					if (checkedItems.get(checkedItems.keyAt(i)))
						selectedListsIds.add(itemList.get(checkedItems.keyAt(i)).getId());
				}
				
				//set the return intent
				Intent returnIntent = new Intent();
				returnIntent.putExtra(SELECTED_LISTS_KEY, selectedListsIds.toArray(new String[] {}));
				setResult(RESULT_OK, returnIntent);
				finish();
			}
		});
		
		getAllLists();
	}
	
	private void getAllLists() {
		new AsyncTask<Void, Void, List<ContactList>>() {
			
			//custom exception that holds the list of errors received from server
			private ConstantContactServiceException mError;
			
			private ProgressDialog mProgressDialog;

			@Override
			protected void onPreExecute() {
				mProgressDialog = ProgressDialog.show(ContactListsActivity.this, null, getString(R.string.kMsgLoading), true, false);
			}

			@Override
			protected List<ContactList> doInBackground(Void... voids) {
				try {
					return GlobalConfig.getInstance().getConstantContactService().getLists(null);
				} catch (ConstantContactServiceException e) {
					mError = e;
				}

				return null;
			}

			@Override
			protected void onPostExecute(List<ContactList> contactList) {
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

					new AlertDialog.Builder(ContactListsActivity.this).setTitle("Server Error").setMessage(errorMessage).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

						}
					}).show();
					return;
				}
				
				itemList = new ArrayList<Item>();
				for (ContactList list : contactList) {

					Item item = new Item();
					item.setDiplayText(String.format("%s", list.getName()));
					item.setId(list.getId());

					itemList.add(item);
				}

				ArrayAdapter<Item> contactListAdapter = new ArrayAdapter<Item>(getBaseContext(), android.R.layout.simple_list_item_multiple_choice, (Item[]) itemList.toArray(new Item[] {}));
				lstContactLists.setAdapter(contactListAdapter);

				initializeListView(initialSelectedListsIds);

			}
		}.execute();
	}

	private void initializeListView(String[] selectedLists) {
		if(selectedLists != null) {
			for(int i = 0; i < itemList.size(); i++) {
				for(String id : selectedLists)
				if(itemList.get(i).getId().compareTo(id) == 0)
					lstContactLists.setItemChecked(i, true);
			}
		}
	}
}
