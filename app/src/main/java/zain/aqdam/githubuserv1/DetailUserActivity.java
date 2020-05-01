package zain.aqdam.githubuserv1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailUserActivity extends AppCompatActivity {
    public static final String EXTRA_USER ="extra_user";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);
        User user = getIntent().getParcelableExtra(EXTRA_USER);
        final TextView tvName = findViewById(R.id.tv_detail_name);
        final TextView tvUserName = findViewById(R.id.tv_detail_username);
        final ImageView ivPhoto = findViewById(R.id.img_detail_photo);
        final TextView tvRepository = findViewById(R.id.tv_detail_repository);
        final TextView tvFollowers = findViewById(R.id.tv_detail_followers);
        final TextView tvFollowing = findViewById(R.id.tv_detail_following);
        final TextView tvCompany = findViewById(R.id.tv_detail_company);
        final TextView tvLocation = findViewById(R.id.tv_detail_location);

        tvName.setText(user.getName());
        tvUserName.setText(user.getUsername());
        tvRepository.setText(Integer.toString(user.getRepository()));
        tvFollowers.setText(Integer.toString(user.getFollowers()));
        tvFollowing.setText(Integer.toString(user.getFollowing()));
        tvCompany.setText(user.getCompany());
        tvLocation.setText(user.getLocation());


        Glide.with(DetailUserActivity.this)
                .load(user.getAvatar())
                .apply(new RequestOptions().override(110, 110))
                .into(ivPhoto);
    }
}
