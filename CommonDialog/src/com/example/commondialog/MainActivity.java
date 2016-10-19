package com.example.commondialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

import com.example.commondialog.dialog.CommonDialog;

public class MainActivity extends ActionBarActivity {
	private int index = 0;
	private String[] picture;
	private TextView textView1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		textView1 = (TextView) findViewById(R.id.textView1);

		findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				// click();
				click1();

			}

			private void click1() {
				CommonDialog dialog = CommonDialog
						.getPinterestDialogCancelable(MainActivity.this);
				dialog.setMessage(R.string.hah);
				// 可选择要不要ok按钮
				dialog.setPositiveButton("ok",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								dialog.dismiss();
							}
						});
				dialog.show();
			}

			private void click() {
				picture = getResources().getStringArray(R.array.choose_picture);
				String text = textView1.getText().toString();
				for (int i = 0; i < picture.length; i++) {
					if (picture[i].equals(text)) {
						index = i;
						break;
					}
				}
				final CommonDialog dialog = CommonDialog
						.getPinterestDialogCancelable(MainActivity.this);
				dialog.setTitle(R.string.choose_picture);
				dialog.setNegativeButton(R.string.cancle, null);
				dialog.setItems(picture, index, new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						dialog.dismiss();
						textView1.setText(picture[position]);
					}
				});
				dialog.show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
