package com.arin.thestudent;

//,elakukan import library yang digunakan dalam aplikasi android
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.arin.thestudent.model.Mahasiswa;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //mendeklarasikan elemen-elemen seperti EditText, Spinner, dan Button
    private EditText edtDate, edtUsername, edtFullname, edtNIM, edtAddress, edtEmail, edtPhone, edtPassword, edit_konfirmasi;
    private Spinner spinnerGender;
    private Button btnRegister;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi view d ari form input
        edtUsername = findViewById(R.id.edt_username);
        edtFullname = findViewById(R.id.edt_fullname);
        edtNIM = findViewById(R.id.edt_nim);
        edtDate = findViewById(R.id.edt_date);
        spinnerGender = findViewById(R.id.spinner);
        edtAddress = findViewById(R.id.edt_address);
        edtEmail = findViewById(R.id.edt_email);
        edtPhone = findViewById(R.id.edt_phone);
        edtPassword = findViewById(R.id.edt_password);
        edit_konfirmasi = findViewById(R.id.edit_konfirmasi);
        btnRegister = findViewById(R.id.btn_register); //Set action untuk tombol register (untuk mengambil input form dan tampilkan di Toast)

        // Tambahkan inisialisasi untuk btnRegister
        btnRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Mengambil input dari setiap field EditText dan Spinner
                String username = edtUsername.getText().toString();
                String fullname = edtFullname.getText().toString();
                String nim = edtNIM.getText().toString();
                String date = edtDate.getText().toString();
                String gender = spinnerGender.getSelectedItem().toString();
                String address = edtAddress.getText().toString();
                String email = edtEmail.getText().toString();
                String phone = edtPhone.getText().toString();
                String password = edtPassword.getText().toString();
                String konfirmasi = edit_konfirmasi.getText().toString();
                //menampilkan input yang diambil dalam bentuk Toast
                Toast.makeText(MainActivity.this,
                        "Nama: " + fullname + ", Email: " + email + ", Tanggal Lahir: " + date+
                                ", Jenis Kelamin: " + gender + ", Konfirmasi Password: " + konfirmasi,
                        Toast.LENGTH_LONG).show();

                //membuat objek mahasiswa untuk menyimpan inpurt data
                Mahasiswa mahasiswa = new Mahasiswa();
                mahasiswa.setUsername(username);
                mahasiswa.setFullname(fullname);
                mahasiswa.setNim(nim);
                mahasiswa.setDate(date);
                mahasiswa.setGender(gender);
                mahasiswa.setAddress(address);
                mahasiswa.setEmail(email);
                mahasiswa.setPhone(phone);
                mahasiswa.setPassword(password);
                //menampilkan data mahasiswa dalam Toast
                Toast.makeText(MainActivity.this, "Nama: " + mahasiswa.getFullname() + ", email: " + mahasiswa.getEmail(), Toast.LENGTH_LONG).show();

            }
        });

        // Atur Spinner untuk pilihan jenis kelamin
        String[] genderOptions = {"Laki-laki", "Perempuan"};
        ArrayAdapter<String> genderAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, genderOptions);
        spinnerGender.setAdapter(genderAdapter);

        // Atur DatePicker pada EditText Tanggal Lahir
        edtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        // Mengatur padding untuk system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Fungsi untuk menampilkan DatePickerDialog
    private void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // Set nilai tanggal yang dipilih ke EditText
                edtDate.setText(String.format("%02d/%02d/%d", dayOfMonth, monthOfYear + 1, year));
            }
        }, year, month, day);
        datePickerDialog.show();
    }
}