package com.example.books;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


public class SearchTheme extends AppCompatActivity {
    private EditText SearchField;
    private ImageButton SearchBtn;
    private RecyclerView ResultList;
    Button BtnFrag;

    private DatabaseReference mBookDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_theme);


        mBookDatabase = FirebaseDatabase.getInstance().getReference("BookCases");
        SearchField = findViewById(R.id.Search_Field);
        SearchBtn = findViewById(R.id.Search_Btn);

        ResultList = findViewById(R.id.Result_List);
        ResultList.setHasFixedSize(true);
        ResultList.setLayoutManager(new LinearLayoutManager(this));

        BtnFrag = findViewById(R.id.BtnFrag);

        BtnFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenFragment();
            }
        });



        SearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchText = SearchField.getText().toString();
                firebaseBookSearch(searchText);
            }
        });
    }

    private void OpenFragment() {
        Intent intent = new Intent(this,FrMainActivity.class);
        startActivity(intent);
    }

    private void firebaseBookSearch(String searchText) {
               Toast.makeText(this,"Started Search",Toast.LENGTH_LONG).show();
                Query firebaseSearchQuery = mBookDatabase.orderByChild("TitleBook").startAt(searchText).endAt(searchText+ "\uf8ff");
                FirebaseRecyclerAdapter<BookCases, BookCasesViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<BookCases, BookCasesViewHolder>(

                        BookCases.class,
                        R.layout.list_layout,
                        BookCasesViewHolder.class,
                        mBookDatabase

                ) {
                    protected void populateViewHolder(BookCasesViewHolder viewHolder, BookCases model, int position) {
                        viewHolder.setDetails(getApplicationContext(), model.getTitleBook(),model.getAuthorName(),model.getPrice(),model.getImg());
                    }
                };
                ResultList.setAdapter(firebaseRecyclerAdapter);

            }

    public void Exit(View view) {
        Intent i = new Intent(this,Login.class);
        startActivity(i);
    }

    public static class BookCasesViewHolder extends RecyclerView.ViewHolder {

                View mView;

                public BookCasesViewHolder(View itemView) {
                    super(itemView);
                    mView = itemView;

                }

                public void setDetails(Context ctx, String BookTitle, String BookAuthor, String BookPrice, String Bookimage) {
                    TextView Book_Title = mView.findViewById(R.id.Title_txt);
                    TextView Book_Author = mView.findViewById(R.id.Author_txt);
                    TextView Book_Price = mView.findViewById(R.id.Price_txt);
                    ImageButton Book_image = mView.findViewById(R.id.Book_image);

                    Book_Title.setText(BookTitle);
                    Book_Author.setText(BookAuthor);
                    Book_Price.setText(BookPrice);
                    Glide.with(ctx).load(Bookimage).into(Book_image);


                }

            }
        }


