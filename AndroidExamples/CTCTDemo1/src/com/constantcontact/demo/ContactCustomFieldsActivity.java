package com.constantcontact.demo;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.constantcontact.components.contacts.CustomField;

public class ContactCustomFieldsActivity extends Activity {

	private static final String CUSTOM_FIELDS_KEY = "CUSTOM_FIELDS";

	ArrayList<EditText> customEditTextFields = new ArrayList<EditText>();
	ArrayList<CustomField> customfieldsList;

	Button btnSave;

	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_custom_fields);
		setTitle("Custom Fields");
		
		//get the custom field list from ContactDetails activity
		Bundle extras = getIntent().getExtras();
		customfieldsList = (ArrayList<CustomField>) extras.getSerializable(CUSTOM_FIELDS_KEY);

		//get all 15 editTexts
		TableLayout table = (TableLayout) findViewById(R.id.tblCustomFields);
		
		for (int i = 0; i < table.getChildCount(); i++) {
			TableRow row = (TableRow) table.getChildAt(i);
			
			for (int j = 0; j < row.getChildCount(); j++)
				if (row.getChildAt(j) instanceof EditText)
					customEditTextFields.add((EditText) row.getChildAt(j));
		}
		
		//populate them acordingly to customFields List
		for (CustomField customField : customfieldsList) {
			int id = Integer.parseInt(customField.getName().replaceAll("\\D", ""));
			customEditTextFields.get(id - 1).setText(customField.getValue());
		}
		
		btnSave = (Button) findViewById(R.id.btnCustomFieldsSave);
		btnSave.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				customfieldsList.clear();
				
				//update the customFields list
				for (int i = 0; i < customEditTextFields.size(); i++) {
					EditText editText = customEditTextFields.get(i);

					if (editText.getText().length() > 0) {
						CustomField customField = new CustomField();
						customField.setName("CustomField" + (i + 1));
						customField.setValue(editText.getText().toString());

						customfieldsList.add(customField);
					}
				}
				
				// set the result intent
				Intent returnIntent = new Intent();
				returnIntent.putExtra(CUSTOM_FIELDS_KEY, customfieldsList);
				setResult(RESULT_OK, returnIntent);
				finish();
			}
		});
	}
}
