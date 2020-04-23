package com.example.samsungproject.fragments;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.samsungproject.Purpose;
import com.example.samsungproject.R;

import java.util.ArrayList;

class RecycleAdapter extends RecyclerView.Adapter<ContactVH> {
    final ArrayList<Purpose> purposeList;

    public RecycleAdapter(ArrayList<Purpose> userList) {
        this.purposeList = userList;
    }


    @NonNull
    @Override
    public ContactVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View contactView = LayoutInflater.from(parent.getContext()).inflate(R.layout.purpose_view, parent, false);
        return new ContactVH(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactVH holder, int position) {
        Purpose purpose = purposeList.get(position);
        holder.bind(purpose);
    }

    @Override
    public int getItemCount() {
        return purposeList.size();
    }
}

class ContactVH extends RecyclerView.ViewHolder {
    TextView deadline, head, stat;

    public ContactVH(@NonNull View itemView) {
        super(itemView);
        deadline = itemView.findViewById(R.id.deadline);
        stat = itemView.findViewById(R.id.stat);
        head = itemView.findViewById(R.id.head);

    }

    public void bind(Purpose purpose) {
        deadline.setText(purpose.deadline);
        stat.setText(purpose.stat);
        head.setText(purpose.head);
    }
}