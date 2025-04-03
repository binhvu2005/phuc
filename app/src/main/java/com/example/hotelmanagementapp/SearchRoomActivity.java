package com.example.hotelmanagementapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class SearchRoomActivity extends AppCompatActivity {
    private EditText edtMinPrice, edtMaxPrice;
    private Button btnSearch;
    private RecyclerView recyclerViewRooms;
    private RoomAdapter roomAdapter;
    private List<Room> allRooms;
    private List<Room> filteredRooms;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_room);

        edtMinPrice = findViewById(R.id.edtMinPrice);
        edtMaxPrice = findViewById(R.id.edtMaxPrice);
        btnSearch = findViewById(R.id.btnSearch);
        recyclerViewRooms = findViewById(R.id.recyclerViewRooms);

        recyclerViewRooms.setLayoutManager(new LinearLayoutManager(this));

        // Dữ liệu giả
        allRooms = new ArrayList<>();
        allRooms.add(new Room("Khách sạn A", 101, "Standard", 400000));
        allRooms.add(new Room("Khách sạn B", 202, "Deluxe", 600000));
        allRooms.add(new Room("Khách sạn C", 303, "VIP", 800000));
        allRooms.add(new Room("Khách sạn D", 404, "Standard", 500000));
        allRooms.add(new Room("Khách sạn E", 505, "Deluxe", 450000));

        filteredRooms = new ArrayList<>(allRooms);
        roomAdapter = new RoomAdapter(filteredRooms);
        recyclerViewRooms.setAdapter(roomAdapter);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterRooms();
            }
        });
    }

    private void filterRooms() {
        String minPriceStr = edtMinPrice.getText().toString();
        String maxPriceStr = edtMaxPrice.getText().toString();

        int minPrice = minPriceStr.isEmpty() ? 0 : Integer.parseInt(minPriceStr);
        int maxPrice = maxPriceStr.isEmpty() ? Integer.MAX_VALUE : Integer.parseInt(maxPriceStr);

        filteredRooms.clear();
        for (Room room : allRooms) {
            if (room.getPrice() >= minPrice && room.getPrice() <= maxPrice) {
                filteredRooms.add(room);
            }
        }

        roomAdapter.notifyDataSetChanged();
    }
}
