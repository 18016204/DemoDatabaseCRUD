package sg.edu.rp.c346.id18016204.demodatabasecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class editActivity extends AppCompatActivity {

    TextView tvID;
    EditText etContent;
    Button btnUpdate, btnDelete;
    Note data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        tvID = findViewById(R.id.tvID);
        etContent = findViewById(R.id.etContent);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        Intent i  = getIntent();
        data = (Note)i.getSerializableExtra("data");
        tvID.setText("ID : " + data.getId());
        etContent.setText(data.getNoteContent());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbh = new DBHelper(editActivity.this);
                data.setNoteContent(etContent.getText().toString());
                dbh.updateNote(data);
                dbh.close();
                Intent i = new Intent();
                i.putExtra("data", data);
                setResult(RESULT_OK, i);
                finish();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbh = new DBHelper(editActivity.this);
                dbh.deleteNote(data.getId());
                dbh.close();
                Intent i = new Intent();
                i.putExtra("data", data);
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }

}