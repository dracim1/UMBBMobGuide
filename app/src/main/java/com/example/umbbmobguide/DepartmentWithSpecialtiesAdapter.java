package com.example.umbbmobguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class DepartmentWithSpecialtiesAdapter extends BaseAdapter {
    
    private Context context;
    private ArrayList<Department> departments;
    
    public DepartmentWithSpecialtiesAdapter(Context context, ArrayList<Department> departments) {
        this.context = context;
        this.departments = departments;
    }
    
    @Override
    public int getCount() {
        return departments.size();
    }
    
    @Override
    public Object getItem(int position) {
        return departments.get(position);
    }
    
    @Override
    public long getItemId(int position) {
        return position;
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        
        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.list_item_department_with_specialties, parent, false);
            holder = new ViewHolder();
            holder.tvDepartmentName = convertView.findViewById(R.id.tvDepartmentName);
            holder.tvDepartmentDescription = convertView.findViewById(R.id.tvDepartmentDescription);
            holder.specialtiesContainer = convertView.findViewById(R.id.specialtiesContainer);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        
        Department department = departments.get(position);
        
        holder.tvDepartmentName.setText(department.getName());
        holder.tvDepartmentDescription.setText(department.getDescription());
        
        // Clear previous specialties
        holder.specialtiesContainer.removeAllViews();
        
        // Add specialties
        ArrayList<String> specialties = department.getSpecialties();
        if (specialties != null && !specialties.isEmpty()) {
            // Add License and Master groups
            ArrayList<String> licenses = new ArrayList<>();
            ArrayList<String> masters = new ArrayList<>();
            
            for (String specialty : specialties) {
                if (specialty.toLowerCase().contains("license")) {
                    licenses.add(specialty);
                } else if (specialty.toLowerCase().contains("master")) {
                    masters.add(specialty);
                }
            }
            
            // Add License section if exists
            if (!licenses.isEmpty()) {
                TextView licenseTitle = new TextView(context);
                licenseTitle.setText("📚 Undergraduate Programs");
                licenseTitle.setTextSize(13f);
                licenseTitle.setTextStyle(android.graphics.Typeface.BOLD);
                licenseTitle.setTextColor(ContextCompat.getColor(context, R.color.blue_primary));
                licenseTitle.setPadding(0, 8, 0, 4);
                holder.specialtiesContainer.addView(licenseTitle);
                
                for (String license : licenses) {
                    addSpecialtyItem(holder.specialtiesContainer, license);
                }
            }
            
            // Add Master section if exists
            if (!masters.isEmpty()) {
                TextView masterTitle = new TextView(context);
                masterTitle.setText("🎓 Graduate Programs");
                masterTitle.setTextSize(13f);
                masterTitle.setTextStyle(android.graphics.Typeface.BOLD);
                masterTitle.setTextColor(ContextCompat.getColor(context, R.color.blue_primary));
                masterTitle.setPadding(0, 12, 0, 4);
                holder.specialtiesContainer.addView(masterTitle);
                
                for (String master : masters) {
                    addSpecialtyItem(holder.specialtiesContainer, master);
                }
            }
        }
        
        return convertView;
    }
    
    private void addSpecialtyItem(LinearLayout container, String specialty) {
        TextView tv = new TextView(context);
        String displayText = specialty;
        if (specialty.contains(":")) {
            displayText = "• " + specialty.split(":")[1].trim();
        } else {
            displayText = "• " + specialty;
        }
        tv.setText(displayText);
        tv.setTextSize(13f);
        tv.setPadding(16, 6, 0, 6);
        tv.setTextColor(ContextCompat.getColor(context, R.color.text_gray));
        container.addView(tv);
    }
    
    static class ViewHolder {
        TextView tvDepartmentName;
        TextView tvDepartmentDescription;
        LinearLayout specialtiesContainer;
    }
}
