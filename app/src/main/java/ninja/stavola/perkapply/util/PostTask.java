package ninja.stavola.perkapply.util;

import android.os.AsyncTask;
import android.widget.Toast;

import com.github.kevinsawicki.http.HttpRequest;

import ninja.stavola.perkapply.Perkapply;

public class PostTask extends AsyncTask<String, Long, String> {
    private String perkaFieldsJson = PerkaFields.getInstance().getJson();

    @Override
    protected String doInBackground(String... urls) {
        boolean response = HttpRequest.post(urls[0]).send(perkaFieldsJson).ok();

        return (response) ? "Application Submitted!" : "Application Failed!";
    }

    @Override
    protected void onPostExecute(String message) {
        Toast.makeText(Perkapply.getAppContext(), message, Toast.LENGTH_LONG).show();
    }
}
