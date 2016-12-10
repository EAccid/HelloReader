package com.eaccid.bookreader.pagerfragments.fragment_0;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.eaccid.bookreader.R;
import com.eaccid.bookreader.db.AppDatabaseManager;
import com.eaccid.bookreader.file.pagesplitter.Page;
import java.util.List;

public class BookReaderRecyclerViewAdapter extends RecyclerView.Adapter<BookReaderRecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "BookReaderRecyclerViewAdapter";
    private List<Page<String>> mPagesList;

    public BookReaderRecyclerViewAdapter(List<Page<String>> mPagesList) {
        this.mPagesList = mPagesList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.book_page_text_default, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Page<String> page = mPagesList.get(position);
        AppDatabaseManager.setCurrentPageForAddingWord(page.getPageNumber());
        holder.getTextOnPageTextView().setText(page.getDataFromPage());
        holder.getPageNumberTextView().setText(
                String.valueOf(position + 1) +
                        " - " +
                        String.valueOf(mPagesList.size())
        );
        holder.getTextOnPageTextView().setOnTouchListener(new OnWordFromTextViewTouchListener(page.getPageNumber()));
    }

    @Override
    public int getItemCount() {
        return mPagesList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textOnPageTextView;
        private final TextView pageNumberTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            textOnPageTextView = (TextView) itemView.findViewById(R.id.text_on_page);
            pageNumberTextView = (TextView) itemView.findViewById(R.id.page_number);
        }

        public TextView getTextOnPageTextView() {
            return textOnPageTextView;
        }

        public TextView getPageNumberTextView() {
            return pageNumberTextView;
        }
    }

}