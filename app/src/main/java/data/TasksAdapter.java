package data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.nawrustaskmng.R;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

public class TasksAdapter extends ArrayAdapter<Mytask> {

    public TasksAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    /**
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View vitem= LayoutInflater.from(getContext()).inflate(R.layout.taskitem,parent,false);
        TextView tvTitle=vitem.findViewById(R.id.itmTvTitle);
        TextView tvSubject=vitem.findViewById(R.id.itmTvSubject);
        RatingBar rbPrio=vitem.findViewById(R.id.itmRatingPriority);
        CheckBox cbIsCompleted=vitem.findViewById(R.id.itmchbxIsCompleted);
        ImageView ivInfo=vitem.findViewById(R.id.itmImageInfo);
        //getting data source
        final Mytask mytask = getItem(position);


        //todo טיפול באירוע מחיקה
        cbIsCompleted.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    FireBaseUtils.getReference().child(mytask.getKey()).removeValue(new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                            if(databaseError==null)
                            {
                                Toast.makeText(getContext(),"deleted",Toast.LENGTH_SHORT).show();


                            }
                            else {
                                Toast.makeText(getContext(),"not deleted"+databaseError.getMessage(),Toast.LENGTH_SHORT).show();

                            }

                        }
                    });

                }
            }
        });

        //connect item view to data source
        tvTitle.setText(mytask.getTitle());
        tvSubject.setText(mytask.getSubject());
        rbPrio.setRating(mytask.getImportant());
        cbIsCompleted.setChecked(false);
        return vitem;

    }
}
