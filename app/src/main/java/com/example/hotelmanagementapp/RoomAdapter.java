package com.example.hotelmanagementapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.RoomViewHolder> {
    private List<Room> roomList;

    public RoomAdapter(List<Room> roomList) {
        this.roomList = roomList;
    }

    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.room_item, parent, false);
        return new RoomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomViewHolder holder, int position) {
        Room room = roomList.get(position);
        holder.txtHotelName.setText(room.getHotelName());
        holder.txtRoomNumber.setText("Số phòng: " + room.getRoomNumber());
        holder.txtRoomType.setText("Loại phòng: " + room.getRoomType());
        holder.txtRoomPrice.setText("Giá: " + room.getPrice() + " VNĐ");
    }

    @Override
    public int getItemCount() {
        return roomList.size();
    }

    public static class RoomViewHolder extends RecyclerView.ViewHolder {
        TextView txtHotelName, txtRoomNumber, txtRoomType, txtRoomPrice;

        public RoomViewHolder(@NonNull View itemView) {
            super(itemView);
            txtHotelName = itemView.findViewById(R.id.txtHotelName);
            txtRoomNumber = itemView.findViewById(R.id.txtRoomNumber);
            txtRoomType = itemView.findViewById(R.id.txtRoomType);
            txtRoomPrice = itemView.findViewById(R.id.txtRoomPrice);
        }
    }
}
