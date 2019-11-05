package com.example.nawrustaskmng.ui.main;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.nawrustaskmng.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import data.Mytask;
import data.TasksAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllTasksFragment extends Fragment {
    private TasksAdapter tasksAdapter;
    private ListView lvTasks;
    private View IvTasks;


    public AllTasksFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tasksAdapter=new TasksAdapter(getContext(),R.layout.taskitem);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_tasks2, container, false);
        IvTasks=view.findViewById(R.id.lstTasks);
        lvTasks.setAdapter(tasksAdapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        readTasksFromFirebase();
    }

    public void readTasksFromFirebase(){
        FirebaseDatabase database=FirebaseDatabase.getInstance();//to connect to database
        FirebaseAuth auth=FirebaseAuth.getInstance();//to get current UID
        String uid = auth.getUid();
        DatabaseReference reference = database.getReference();
        tasksAdapter.clear();
        reference.child("tasks").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot d:dataSnapshot.getChildren()) {
                    Mytask t=d.getValue(Mytask.class);
                    Log.d("MYTASK",t.toString());
                    tasksAdapter.add(t);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
