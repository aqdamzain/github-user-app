package zain.aqdam.githubuserv1;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListUserAdapter extends RecyclerView.Adapter<ListUserAdapter.ListViewHolder> {
    private ArrayList<User> listUser;

    public ListUserAdapter(ArrayList<User> list){
        this.listUser = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_user, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        final User user = listUser.get(position);

        Glide.with(holder.itemView.getContext())
                .load(user.getAvatar())
                .apply(new RequestOptions().override(70, 70))
                .into(holder.imgAvatar);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Kamu memilih " + user.getName(), Toast.LENGTH_SHORT).show();
                Intent mIntent = new Intent(v.getContext(), DetailUserActivity.class);
                mIntent.putExtra(DetailUserActivity.EXTRA_USER, user);
                v.getContext().startActivity(mIntent);
            }
        });
        holder.tvName.setText(user.getName());
        holder.tvUsername.setText(user.getUsername());

    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAvatar;
        TextView tvName, tvUsername;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvUsername = itemView.findViewById(R.id.tv_item_username);
        }
    }
}
