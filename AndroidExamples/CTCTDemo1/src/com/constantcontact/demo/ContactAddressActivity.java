package com.constantcontact.demo;

import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.constantcontact.components.contacts.Address;

public class ContactAddressActivity extends Activity {

	private static final String ADDRESS_KEY = "ADDRESS";

	Address address;

	private EditText txtLine1;
	private EditText txtLine2;
	private EditText txtLine3;
	private EditText txtCity;
	private EditText txtState;
	private EditText txtStateOther;
	private EditText txtPostalCode;
	private EditText txtSubPostalCode;
	private EditText txtCountry;

	private Button btnSave;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_address);
		
		//get the address object from ContactDetailsActivity
		Bundle extras = getIntent().getExtras();
		address = (Address) extras.getSerializable(ADDRESS_KEY);

		//initialize UI controls
		txtLine1 = (EditText) findViewById(R.id.txtline1);
		txtLine2 = (EditText) findViewById(R.id.txtline2);
		txtLine3 = (EditText) findViewById(R.id.txtline3);
		txtCity = (EditText) findViewById(R.id.txtCity);
		txtState = (EditText) findViewById(R.id.txtState);
		txtStateOther = (EditText) findViewById(R.id.txtStateOther);
		txtPostalCode = (EditText) findViewById(R.id.txtPostalCode);
		txtSubPostalCode = (EditText) findViewById(R.id.txtSubPostalCode);
		txtCountry = (EditText) findViewById(R.id.txtCountry);

		if (address != null) {
			txtLine1.setText(address.getLine1());
			txtLine2.setText(address.getLine2());
			txtLine3.setText(address.getLine3());
			txtCity.setText(address.getCity());
			txtState.setText(address.getCountryCode().toUpperCase(Locale.ENGLISH).compareTo("US") == 0 ? address.getStateCode() : "");
			txtStateOther.setText(address.getCountryCode().toUpperCase(Locale.ENGLISH).compareTo("US") == 0 ? "" : address.getStateCode());
			txtPostalCode.setText(address.getPostalCode());
			txtSubPostalCode.setText(address.getSubPostalCode());
			txtCountry.setText(address.getCountryCode());
		} else {
			address = new Address();
		}
		
		btnSave = (Button) findViewById(R.id.btnAddressSave);
		btnSave.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				//update address object
				address.setLine1(txtLine1.getText().toString());
				address.setLine2(txtLine2.getText().toString());
				address.setLine3(txtLine3.getText().toString());
				address.setCity(txtCity.getText().toString());
				
				if (txtState.length() > 0)
					address.setStateCode(txtState.getText().toString());
				
				if (txtStateOther.length() > 0)
					address.setStateCode(txtStateOther.getText().toString());

				address.setPostalCode(txtPostalCode.getText().toString());
				address.setSubPostalCode(txtSubPostalCode.getText().toString());
				address.setCountryCode(txtCountry.getText().toString());
				
				//set the result intent
				Intent returnIntent = new Intent();
				returnIntent.putExtra(ADDRESS_KEY, address);
				setResult(RESULT_OK, returnIntent);
				finish();
			}
		});
	}

}
