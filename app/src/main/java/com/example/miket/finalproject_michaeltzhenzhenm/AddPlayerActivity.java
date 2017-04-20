package com.example.miket.finalproject_michaeltzhenzhenm;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.FileProvider;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddPlayerActivity extends AppCompatActivity {

    private static final int REQUEST_TAKE_PHOTO = 1;
    private static final int REQUEST_PICK_PHOTO = 2;
    String gender = "N/A";
    String parent1Title = "N/A";
    String parent2Title = "N/A";
    FirebaseDatabase database;
    DatabaseReference playerRef;
    DatabaseReference parent1Ref;
    DatabaseReference parent2Ref;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private String TAG = "AddPlayerActivity";
    private ImageView imageView;
    private File photoFile;
    private StorageReference mStorageRef;
    private Uri fileToUpload;
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);

        imageView = (ImageView) findViewById(R.id.image);
        mStorageRef = FirebaseStorage.getInstance().getReference();

        database = FirebaseDatabase.getInstance();
        playerRef = database.getReference("player");
        parent1Ref = database.getReference("parent 1");
        parent2Ref = database.getReference("parent 2");

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                    Intent intent = new Intent(AddPlayerActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                // ...
            }
        };

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_player, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_clear_all_tabs:
//                ADD STUFF!!!!!!!!!!!!!!!!!!!!!!!!
                return true;
            case R.id.action_clear_this_tab:
//                ADD STUFF!!!!!!!!!!!!!!!!!!!!!!!!
                return true;
            case R.id.action_settings:
//                ADD STUFF!!!!!!!!!!!!!!!!!!!!!!!!
                return true;
            case R.id.add_person:
                save();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }

    public void save() {
        EditText ePlayerFirstName = (EditText) findViewById(R.id.player_first_name);
        EditText ePlayerLastName = (EditText) findViewById(R.id.player_last_name);
        EditText ePlayerEmail = (EditText) findViewById(R.id.player_email);
        EditText ePlayerJerseyNumber = (EditText) findViewById(R.id.player_jersey_number);
        Spinner ePlayerBdayMonth = (Spinner) findViewById(R.id.player_bday_months_spinner);
        Spinner ePlayerBdayDay = (Spinner) findViewById(R.id.player_bday_day_spinner);
        Spinner ePlayerBdayYear = (Spinner) findViewById(R.id.player_bday_year_spinner);
        Spinner eGroupLevelAdd = (Spinner) findViewById(R.id.levels_add_spinner);

        String playerFirstName = ePlayerFirstName.getText().toString();
        String playerLastName = ePlayerLastName.getText().toString();
        String playerEmail = ePlayerEmail.getText().toString();
        String playerJerseyNum = ePlayerJerseyNumber.getText().toString();
        String playerBdayMonth = ePlayerBdayMonth.getSelectedItem().toString();
        String playerBdayDay = ePlayerBdayDay.getSelectedItem().toString();
        String playerBdayYear = ePlayerBdayYear.getSelectedItem().toString();
        String groupLevelAdd = eGroupLevelAdd.getSelectedItem().toString();

        StorageReference uploadRef = mStorageRef.child("images/upload.jpg");

        uploadRef.putFile(fileToUpload)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // Get a URL to the uploaded content
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        // ...
                    }
                });

        Toast.makeText(AddPlayerActivity.this, "Uploaded Successfully!", Toast.LENGTH_SHORT).show();

        Player player = new Player(playerFirstName, playerLastName, playerEmail, playerJerseyNum,
                playerBdayMonth, playerBdayDay, playerBdayYear, gender, groupLevelAdd);

        playerRef.push().setValue(player);


        EditText eParent1FirstName = (EditText) findViewById(R.id.parent1_first_name);
        EditText eParent1LastName = (EditText) findViewById(R.id.parent1_last_name);
        EditText eParent1Email = (EditText) findViewById(R.id.parent1_email);
        EditText eParent1PhoneNum = (EditText) findViewById(R.id.parent1_phone);

        String parent1FirstName = eParent1FirstName.getText().toString();
        String parent1LastName = eParent1LastName.getText().toString();
        String parent1Email = eParent1Email.getText().toString();
        String parent1PhoneNum = eParent1PhoneNum.getText().toString();

        Parent parent1 = new Parent(parent1Title, parent1FirstName, parent1LastName, parent1Email, parent1PhoneNum);
        parent1Ref.push().setValue(parent1);

        EditText eParent2FirstName = (EditText) findViewById(R.id.parent2_first_name);
        EditText eParent2LastName = (EditText) findViewById(R.id.parent2_last_name);
        EditText eParent2Email = (EditText) findViewById(R.id.parent2_email);
        EditText eParent2PhoneNum = (EditText) findViewById(R.id.parent2_phone);

        String parent2FirstName = eParent2FirstName.getText().toString();
        String parent2LastName = eParent2LastName.getText().toString();
        String parent2Email = eParent2Email.getText().toString();
        String parent2PhoneNum = eParent2PhoneNum.getText().toString();

        Parent parent2 = new Parent(parent2Title, parent2FirstName, parent2LastName, parent2Email, parent2PhoneNum);

        parent2Ref.push().setValue(parent2);
    }

    public void onGenderClick(View view) {
        boolean genderChecked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.male_radio:
                if (genderChecked) {
                    gender = "Male";
                }
                break;
            case R.id.female_radio:
                if (genderChecked) {
                    gender = "Female";
                }
        }
    }

    public void onTitleClickParent1(View view) {
        boolean titleChecked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.parent1_title_mr:
                if (titleChecked) {
                    parent1Title = "Mr.";
                }
                break;
            case R.id.parent1_title_mrs:
                if (titleChecked) {
                    parent1Title = "Mrs.";
                }
            case R.id.parent1_title_ms:
                if (titleChecked) {
                    parent1Title = "Ms.";
                }
            case R.id.parent1_title_miss:
                if (titleChecked) {
                    parent1Title = "Miss";
                }
        }
    }


    public void onTitleClickParent2(View view) {
        boolean titleChecked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.parent2_title_mr:
                if (titleChecked) {
                    parent2Title = "Mr.";
                }
                break;
            case R.id.parent2_title_mrs:
                if (titleChecked) {
                    parent2Title = "Mrs.";
                }
            case R.id.parent2_title_ms:
                if (titleChecked) {
                    parent2Title = "Ms.";
                }
            case R.id.parent2_title_miss:
                if (titleChecked) {
                    parent2Title = "Miss";
                }
        }
    }

    public void takeProfilePhoto(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (intent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.miket.finalproject_michaeltzhenzhenm",
                        photoFile);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(intent, REQUEST_TAKE_PHOTO);
            }
        }
    }


    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );
        return image;
    }

    public void pickPhoto(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, REQUEST_PICK_PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK)
            return;

        if (requestCode == REQUEST_TAKE_PHOTO) {
            fileToUpload = Uri.parse(photoFile.toURI().toString());
        } else if (requestCode == REQUEST_PICK_PHOTO) {
            fileToUpload = data.getData();
        }
    }


    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    Tab1BasicInfo tab1 = new Tab1BasicInfo();
                    return tab1;
                case 1:
                    Tab2ParentInfo tab2 = new Tab2ParentInfo();
                    return tab2;
                case 2:
                    Tab3MiscInfo tab3 = new Tab3MiscInfo();
                    return tab3;
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Basic Info";
                case 1:
                    return "Parent Info";
                case 2:
                    return "Account Setup";
            }
            return null;
        }
    }
}
