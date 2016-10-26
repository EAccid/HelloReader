package com.eaccid.bookreader.fragment_0;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.eaccid.bookreader.R;

import java.util.List;


public class BookArrayAdapter extends ArrayAdapter<String> {

    private Context mContext;
    private int mTextOnPage;
    private int viewItemLayout;
    private List<String> mPagesList;
    private List<String> mPagesListAll;

    public BookArrayAdapter(Context context, int textViewResourceId, List<String> pagesList) {
        super(context, R.layout.bookpage_item_fragment_0, textViewResourceId, pagesList);
        this.mContext = context;
        this.mTextOnPage = textViewResourceId;
        this.viewItemLayout = R.layout.bookpage_item_fragment_0;
        this.mPagesList = pagesList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolderItem viewHolderItem;

        String textOnPage = mPagesList.get(position);
        int pageNumber = position + 1;

        if (convertView == null) {

            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(viewItemLayout, parent, false);

            viewHolderItem = new ViewHolderItem();
            viewHolderItem.textViewItem = (TextView) convertView.findViewById(mTextOnPage);
            viewHolderItem.pageNumberViewItem = (TextView) convertView.findViewById(R.id.page_number);
            convertView.setTag(viewHolderItem);

        } else {
            viewHolderItem = (ViewHolderItem) convertView.getTag();
        }

        viewHolderItem.textViewItem.setText(textOnPage);
        viewHolderItem.pageNumberViewItem.setText(
                String.valueOf(position + 1) +
                        " - " +
                        String.valueOf(mPagesList.size())
        );
        viewHolderItem.textViewItem.setOnTouchListener(new OnWordFromTextViewTouchListener(pageNumber));

        return convertView;

    }

    private static class ViewHolderItem {
        TextView textViewItem;
        TextView pageNumberViewItem;
    }

}




