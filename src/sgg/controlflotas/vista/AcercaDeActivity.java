package sgg.controlflotas.vista;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class AcercaDeActivity extends Activity implements OnClickListener {
	
	private ImageView email;
	private ImageView twitter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_acerca_de);
		
		email = (ImageView) this.findViewById(R.id.email);
		email.setOnClickListener(this);
		
		twitter = (ImageView) this.findViewById(R.id.twitter);
		twitter.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.acerca_de, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.twitter:
			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/santiguilleng")));				
			break;

		case R.id.email:
			Intent emailIntent = new Intent(Intent.ACTION_SEND);		
			emailIntent.putExtra(Intent.EXTRA_EMAIL, new String [] {"santiagoguillen@gmail.com"});
			emailIntent.putExtra(Intent.EXTRA_SUBJECT, "ControlFlotas App Android");
			emailIntent.setType("message/rfc822");
			startActivity(Intent.createChooser(emailIntent, getString(R.string.clienteMail)));
			break;
		}		
		
	}

}
