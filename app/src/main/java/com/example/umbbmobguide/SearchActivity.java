package com.example.umbbmobguide;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private CardView cardPlaceholder;
    private LinearLayout resultsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        getWindow().setStatusBarColor(
                ContextCompat.getColor(this, R.color.blue_primary)
        );

        cardPlaceholder = findViewById(R.id.cardPlaceholder);

        resultsContainer = new LinearLayout(this);
        resultsContainer.setOrientation(LinearLayout.VERTICAL);
        LinearLayout parent = (LinearLayout) cardPlaceholder.getParent();
        parent.addView(resultsContainer);

        EditText searchInput = findViewById(R.id.searchInput);
        searchInput.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int st, int c, int a) {}
            @Override public void onTextChanged(CharSequence s, int st, int b, int c) {}
            @Override
            public void afterTextChanged(Editable s) {
                String query = s.toString().trim();
                if (query.isEmpty()) {
                    cardPlaceholder.setVisibility(View.VISIBLE);
                    resultsContainer.removeAllViews();
                } else {
                    cardPlaceholder.setVisibility(View.GONE);
                    performSearch(query);
                }
            }
        });

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbarSearch);
        toolbar.setNavigationOnClickListener(v -> finish());

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavSearch);
        bottomNav.setSelectedItemId(R.id.nav_search);
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                startActivity(new Intent(this, MainActivity.class));
                return true;
            } else if (id == R.id.nav_faculties) {
                startActivity(new Intent(this, FacultyActivity.class));
                return true;
            } else if (id == R.id.nav_search) {
                return true;
            }
            return false;
        });
    }

    private void performSearch(String query) {
        resultsContainer.removeAllViews();

        // get faculties with its data
        ArrayList<faculty> allFaculties = DataManager.getFaculties();

        // filter faculties based on query
        List<faculty> results = new ArrayList<>();
        for (faculty f : allFaculties) {
            if (f.facname.toLowerCase().contains(query.toLowerCase())) {
                results.add(f);
            }
        }

        if (results.isEmpty()) {
            TextView tv = new TextView(this);
            tv.setText("No results for \"" + query + "\"");
            tv.setTextColor(ContextCompat.getColor(this, R.color.text_gray));
            tv.setTextSize(14);
            tv.setPadding(0, 24, 0, 0);
            tv.setGravity(Gravity.CENTER);
            resultsContainer.addView(tv);
            return;
        }

        for (faculty f : results) {
            resultsContainer.addView(buildResultRow(f));
        }
    }

    private View buildResultRow(faculty f) {
        CardView card = new CardView(this);
        //set layout width and height
        LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        //Designing Card View
        cardParams.setMargins(0, 0, 0, 12);
        card.setLayoutParams(cardParams);
        card.setRadius(24f);
        card.setCardElevation(6f);
        card.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));

        LinearLayout inner = new LinearLayout(this);
        inner.setOrientation(LinearLayout.HORIZONTAL);
        inner.setGravity(Gravity.CENTER_VERTICAL);
        inner.setPadding(32, 24, 32, 24);

        // Badge: Faculty أو Institute
        TextView badge = new TextView(this);
        LinearLayout.LayoutParams badgeParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        badgeParams.setMarginEnd(16);
        badge.setLayoutParams(badgeParams);
        badge.setText(f.facname.toLowerCase().contains("institute") ? "Institute" : "Faculty");
        badge.setTextSize(10f);
        badge.setTextColor(ContextCompat.getColor(this, R.color.blue_primary));
        badge.setBackgroundColor(0xFFE8F0FB);
        badge.setPadding(16, 6, 16, 6);

        // Name
        TextView tvName = new TextView(this);
        tvName.setLayoutParams(new LinearLayout.LayoutParams(
                0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f
        ));
        tvName.setText(f.facname);
        tvName.setTextSize(14f);
        tvName.setTextColor(ContextCompat.getColor(this, R.color.text_dark));

        // Chevron
        TextView chevron = new TextView(this);
        chevron.setText("›");
        chevron.setTextSize(20f);
        chevron.setTextColor(0xFFCCCCCC);

        inner.addView(badge);
        inner.addView(tvName);
        inner.addView(chevron);
        card.addView(inner);

        // On click: open detail activity
        card.setOnClickListener(v -> {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("DETAIL_TYPE", "faculty");
            intent.putExtra("DETAIL_NAME", f.facname);
            intent.putExtra("DETAIL_DESCRIPTION", f.description);
            intent.putExtra("DETAIL_PHONE", f.phone);
            intent.putExtra("DETAIL_EMAIL", f.email);
            intent.putExtra("DETAIL_LOCATION", f.location);
            intent.putExtra("DETAIL_LATITUDE", f.latitude);
            intent.putExtra("DETAIL_LONGITUDE", f.longitude);
            startActivity(intent);
        });

        return card;
    }
}