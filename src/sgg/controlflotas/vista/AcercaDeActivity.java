package sgg.controlflotas.vista;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class AcercaDeActivity extends Activity implements OnClickListener {
	
	private ImageView email;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_acerca_de);
		
		email = (ImageView) this.findViewById(R.id.email);
		email.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.acerca_de, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		Intent emailIntent = new Intent(Intent.ACTION_SEND);
		
		emailIntent.putExtra(Intent.EXTRA_EMAIL, new String [] {"santiagoguillen@gmail.com"});
		emailIntent.putExtra(Intent.EXTRA_SUBJECT, "ControlFlotas App Android");
		emailIntent.setType("message/rfc822");
		startActivity(Intent.createChooser(emailIntent, getString(R.string.clienteMail)));
		
	}

}
