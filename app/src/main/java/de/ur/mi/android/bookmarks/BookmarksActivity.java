package de.ur.mi.android.bookmarks;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import de.ur.mi.android.bookmarks.bookmarks.Bookmark;

public class BookmarksActivity extends AppCompatActivity {

    private ArrayList<Bookmark> bookmarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmarks);
        bookmarks = new ArrayList<>();
        handleIntent(getIntent());

    }

    private void handleIntent(Intent intent) {
        String intentAction = intent.getAction();
        String intentType = intent.getType();
        if (intentAction == null || intentType == null) {
            return;
        }
        if (intentAction.equals(intent.ACTION_SEND)) {
            if (intentType.equals("text/plain")) {
                bookmarks.add(createBookmark(intent));
            }
        }
    }

    private Bookmark createBookmark(Intent intent) {
        String url = intent.getStringExtra(Intent.EXTRA_TEXT);
        String title = intent.getStringExtra(Intent.EXTRA_SUBJECT);
        try {
            URL bookmarkURL = new URL(url);
            Date creationDate = new Date();
            return (new Bookmark(bookmarkURL, title, creationDate));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
