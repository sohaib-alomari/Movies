package tmdb.omari.com.tmdb;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class DetailActivity extends AppCompatActivity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if(savedInstanceState==null)
        {
          getSupportFragmentManager().beginTransaction().replace(R.id.containerDetail, new DetailActivityFragment()).commit();
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this,Settings.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void trailer1(View v)
    {
            Intent viewTrailer=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v="+DetailActivityFragment.youtube));
            startActivity(viewTrailer);
    }
    public void trailer2(View v)
    {
        Intent viewTrailer=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v="+DetailActivityFragment.youtube2));
        startActivity(viewTrailer);

    }

    public void favorite(View v)
    {
        Button b = (Button)findViewById(R.id.favorite);
        if(b.getText().equals("FAVORITE"))
        {
            //code to store movie data in database
            b.setText("UNFAVORITE");
            b.getBackground().setColorFilter(Color.CYAN, PorterDuff.Mode.MULTIPLY);

        }
        else
        {
            b.setText("FAVORITE");
            b.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
        }
    }


}