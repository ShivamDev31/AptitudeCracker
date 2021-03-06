package com.droidacid.apticalc.more;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.droidacid.apticalc.common.BaseActivity;
import com.droidacid.apticalc.R;

public class Report extends BaseActivity implements OnClickListener {

	private EditText etName;
	private EditText etSubject;
	private EditText etLocation;
	private EditText etBody;
	private String name;
	private String subject;
	private String location;
	private String body;
	private String version;
	private Button bSendMail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initialize();
	}

	@Override
	public int getLayout() {
		return R.layout.more_report;
	}

	private void initialize() {
		etName = (EditText) findViewById(R.id.et_more_Name);
		etSubject = (EditText) findViewById(R.id.et_more_Subject);
		etLocation = (EditText) findViewById(R.id.et_more_Location);
		etBody = (EditText) findViewById(R.id.et_more_Body);

		bSendMail = (Button) findViewById(R.id.b_more_SendMail);

		bSendMail.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		emailValues();
		String[] myEmail = {"makewaysforshivam@gmail.com"};
		String message = "Hello Shivam, \n\n"
				+ body + "\n\n"
				+ name + '\n'
				+ location + "\n\n"
				+ version;

		Intent emailSend = new Intent(android.content.Intent.ACTION_SEND);
		emailSend.putExtra(android.content.Intent.EXTRA_EMAIL, myEmail);
		emailSend.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
		emailSend.setType("plain/text");
		emailSend.putExtra(android.content.Intent.EXTRA_TEXT, message);
		try {
			startActivity(Intent.createChooser(emailSend, "Send mail..."));
		} catch (android.content.ActivityNotFoundException ex) {
			Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
		}

	}

	private void emailValues() {
		name = etName.getText().toString();
		subject = etSubject.getText().toString();
		location = etLocation.getText().toString();
		body = etBody.getText().toString();
		version = getResources().getString(R.string.version);
	}
}