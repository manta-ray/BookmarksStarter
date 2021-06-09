package de.ur.mi.android.bookmarks.ui;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.ur.mi.android.bookmarks.R;
import de.ur.mi.android.bookmarks.bookmarks.Bookmark;

public class BookmarkViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final View bookmarkView;
    private final BookmarkViewHolderListener listener;

    public BookmarkViewHolder(View v, BookmarkViewHolderListener listener) {
        super(v);
        this.bookmarkView = v;
        this.bookmarkView.setOnClickListener(this);
        this.listener = listener;
    }

    public void bindView(Bookmark bookmark) {
        TextView titleView = bookmarkView.findViewById(R.id.bookmark_title);
        TextView urlView = bookmarkView.findViewById(R.id.bookmark_url);
        titleView.setText(bookmark.title);
        urlView.setText(bookmark.url.toString());
    }

    @Override
    public void onClick(View v) {
        listener.onViewClicked(getBindingAdapterPosition());
    }

    public interface BookmarkViewHolderListener {
        void onViewClicked(int position);
    }
}
