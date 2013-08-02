package com.constantcontact.demo2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.constantcontact.components.emailcampaigns.schedules.EmailCampaignSchedule;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.util.CUrlRequestError;

public class ScheduleActivity extends Activity implements View.OnClickListener {

	private static final String LOG_TAG = "CTCT";
	private static final String SCHEDULE_CAMPAIGN_KEY = "SCHEDULE_CAMPAIGN";
	
	private Calendar dateTime = Calendar.getInstance();
	
	private DateFormat dateFormatter = DateFormat.getDateInstance();
    private DateFormat timeFormatter = DateFormat.getTimeInstance();
    
    
    @SuppressLint("SimpleDateFormat")
	private SimpleDateFormat timeStampFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

	private static final int DIALOG_DATE = 1;
	private static final int DIALOG_TIME = 2;

	private EditText txtDate;
	private EditText txtTime;

	Button btnSchedule;

	private String campaignId;
	private EmailCampaignSchedule emailCampaignSchedule;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_schedule);
		setTitle(R.string.kLblScheduleEmailCampaignTitle);
		

		Bundle extras = getIntent().getExtras();
		campaignId = extras.getString(SCHEDULE_CAMPAIGN_KEY);
		emailCampaignSchedule = new EmailCampaignSchedule();


		txtDate = (EditText) findViewById(R.id.txtDate);
		txtDate.setText(dateFormatter.format(dateTime.getTime()));
		txtDate.setFocusable(false);
		txtDate.setClickable(true);
		txtDate.setOnClickListener(this);

		txtTime = (EditText) findViewById(R.id.txtTime);
		txtTime.setText(timeFormatter.format(dateTime.getTime()));
		txtTime.setFocusable(false);
		txtTime.setClickable(true);
		txtTime.setOnClickListener(this);
		

		btnSchedule = (Button) findViewById(R.id.btnSchedule);
		btnSchedule.setOnClickListener(this);

	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DIALOG_DATE:
			return new DatePickerDialog(this, new OnDateSetListener() {

				@Override
				public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
					dateTime.set(year, monthOfYear, dayOfMonth);
					txtTime.setText(dateFormatter.format(dateTime.getTime()));
				}
			}, dateTime.get(Calendar.YEAR), dateTime.get(Calendar.MONTH), dateTime.get(Calendar.DAY_OF_MONTH));

		case DIALOG_TIME:
			return new TimePickerDialog(this, new OnTimeSetListener() {

				@Override
				public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
					dateTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
					dateTime.set(Calendar.MINUTE, minute);
					txtTime.setText(timeFormatter.format(dateTime.getTime()));

				}
			}, dateTime.get(Calendar.HOUR_OF_DAY), dateTime.get(Calendar.MINUTE), false);

		}
		return null;
	}

	private void scheduleCampaign() {
		new AsyncTask<Void, Void, EmailCampaignSchedule>() {
			
			//custom exception that holds the list of errors received from server
			private ConstantContactServiceException mError;
			
			private ProgressDialog mProgressDialog;

			@Override
			protected void onPreExecute() {
				mProgressDialog = ProgressDialog.show(ScheduleActivity.this, null, getString(R.string.kMsgLoading), true, false);
			}

			@Override
			protected EmailCampaignSchedule doInBackground(Void... voids) {
				try {
					return GlobalConfig.getInstance().getConstantContactService().addEmailCampaignSchedule(campaignId, emailCampaignSchedule);
				} catch (ConstantContactServiceException e) {
					mError = e;
				}

				return null;
			}

			@Override
			protected void onPostExecute(final EmailCampaignSchedule emailCampaignSchedResponse) {
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
					
					//display error alert
					new AlertDialog.Builder(ScheduleActivity.this).setTitle("Server Error").setMessage(errorMessage).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

						}
					}).show();
					return;
				}
				
				//no error - Email Campaign Scheduled
				new AlertDialog.Builder(ScheduleActivity.this).setTitle("Info").setMessage("Email Campaign scheduled!").setPositiveButton("Ok", new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// set the return intent
						Intent returnIntent = new Intent();
						setResult(RESULT_OK, returnIntent);
						finish();
					}
				}).show();

			}

		}.execute();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnSchedule:				
			timeStampFormat.setTimeZone(TimeZone.getTimeZone("UTC"));	
			
			emailCampaignSchedule.setScheduledDate(timeStampFormat.format(dateTime.getTime()).toString());
			
			scheduleCampaign();
			break;
		case R.id.txtDate:
			showDialog(DIALOG_DATE);
			break;
		case R.id.txtTime:
			showDialog(DIALOG_TIME);
			break;

		}

	}
}
