package com.example.nicolas.tripndrivecars.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nicolas.tripndrivecars.R;
import com.example.nicolas.tripndrivecars.model.Car;
import com.example.nicolas.tripndrivecars.model.Site;

import java.util.List;

/**
 * Created by Nicolas on 11/12/2015.
 */
public class SiteAdapter extends ArrayAdapter<Site>{

    public SiteAdapter(Context context, List<Site> Sites) {
        super(context, 0, Sites);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.site_cell,parent, false);
        }

        SiteViewHolder viewHolder = (SiteViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new SiteViewHolder();
            viewHolder.completedSiteName = (TextView) convertView.findViewById(R.id.completed_site_name);
            viewHolder.siteTypeIcon = (ImageView) convertView.findViewById(R.id.type_icon);

            convertView.setTag(viewHolder);
        }

        Site site = getItem(position);

        viewHolder.completedSiteName.setText(String.valueOf(site.toString()));
        switch (site.getType()){
            case "station":
                viewHolder.siteTypeIcon.setImageResource(R.drawable.ic_directions_railway_black_24dp);
                break;
            case "airport":
                viewHolder.siteTypeIcon.setImageResource(R.drawable.ic_airplanemode_active_black_24dp);
                break;
            case "city":
                viewHolder.siteTypeIcon.setImageResource(R.drawable.ic_adjust_black_24dp);
                break;
        }

        return convertView;
    }

    private class SiteViewHolder{
        public TextView completedSiteName;
        public ImageView siteTypeIcon;

    }



}
