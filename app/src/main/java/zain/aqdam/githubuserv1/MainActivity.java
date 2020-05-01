package zain.aqdam.githubuserv1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvUsers;
    private ArrayList<User> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvUsers = findViewById(R.id.rv_users);
        rvUsers.setHasFixedSize(true);

        list.addAll(getListUsers());
        showRecyclerList();

    }

    public ArrayList<User> getListUsers(){
        String[] dataName = getResources().getStringArray(R.array.name);
        String[] dataUsername = getResources().getStringArray(R.array.username);
        TypedArray dataAvatar = getResources().obtainTypedArray(R.array.avatar);
        String[] dataLocation = getResources().getStringArray(R.array.location);
        String[] dataCompany = getResources().getStringArray(R.array.company);
        String[] dataRepository = getResources().getStringArray(R.array.repository);
        String[] dataFollowers = getResources().getStringArray(R.array.followers);
        String[] dataFollowing = getResources().getStringArray(R.array.following);

        ArrayList<User> listUser = new ArrayList<>();

        for(int i= 0; i < dataName.length; i++){
            User user = new User();
            user.setName(dataName[i]);
            user.setUsername(dataUsername[i]);
            user.setAvatar(dataAvatar.getResourceId(i, -1));
            user.setLocation(dataLocation[i]);
            user.setCompany(dataCompany[i]);
            user.setRepository(Integer.parseInt(dataRepository[i]));
            user.setFollowers(Integer.parseInt(dataRepository[i]));
            user.setFollowing(Integer.parseInt(dataFollowing[i]));
            listUser.add(user);
        }
        return listUser;
    }

    private void showRecyclerList(){
        rvUsers.setLayoutManager(new LinearLayoutManager(this));
        ListUserAdapter listUserAdapter = new ListUserAdapter(list);
        rvUsers.setAdapter(listUserAdapter);
    }
}
