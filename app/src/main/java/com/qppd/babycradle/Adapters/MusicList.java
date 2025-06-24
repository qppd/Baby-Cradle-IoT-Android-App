package com.qppd.babycradle.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.qppd.babycradle.R;

import java.util.List;

public class MusicList extends ArrayAdapter<String> {

    private Activity context;
    private List<String> titleList;
    private List<String> singerList;

    public MusicList(Activity context, List<String> titleList, List<String> singerList) {
        super(context, R.layout.activity_music, titleList);
        this.context = context;
        this.titleList = titleList;
        this.singerList = singerList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_list_music, null, true);

        String title = titleList.get(position);
        String singer = singerList.get(position);

        TextView txtTitle = listViewItem.findViewById(R.id.txtTitle);
        TextView txtSinger = listViewItem.findViewById(R.id.txtSinger);

        txtTitle.setText(title);
        txtSinger.setText(singer);

        return listViewItem;
    }
}
