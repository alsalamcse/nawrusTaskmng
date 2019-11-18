package data;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FireBaseUtils {
    public static FirebaseAuth auth=FirebaseAuth.getInstance();
    public static FirebaseDatabase db=FirebaseDatabase.getInstance();
    public static DatabaseReference getReference(){
        String uid=auth.getUid();
        return db.getReference().child("task").child(uid);
    }
}
