package com.example.umbbmobguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

// Adapter class for displaying departments in a ListView
public class DepartmentAdapter extends ArrayAdapter<Department> {

    // Constructor: takes the activity context and the list of departments
    public DepartmentAdapter(Context context, ArrayList<Department> departments) {
        super(context, 0, departments);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Reuse existing view if possible, otherwise inflate a new one
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_item_department, parent, false);
        }

        // Get the current Department object
        Department department = getItem(position);

        // Find the TextViews in the row layout
        TextView nameTextView = convertView.findViewById(R.id.tvDepartmentName);
        TextView descriptionTextView = convertView.findViewById(R.id.tvDepartmentDescription);

        // Bind the data to the TextViews
        if (department != null) {
            nameTextView.setText(department.getName());
            descriptionTextView.setText(department.getDescription());
        }

        // Return the completed row view
        return convertView;
    }
}


