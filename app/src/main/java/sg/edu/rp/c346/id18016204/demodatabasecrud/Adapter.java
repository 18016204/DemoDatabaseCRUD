package sg.edu.rp.c346.id18016204.demodatabasecrud;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;


public class Adapter  extends ArrayAdapter {
    Context context;
    ArrayList<Note> notes;
    int resource;
    public Adapter(@NonNull Context context, int resource, ArrayList<Note> notes) {
        super(context, resource);
        this.context = context;
        this.notes = notes;
        this.resource = resource;
    }
}
