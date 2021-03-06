package tk.traiders.ui.profile.avatars;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import tk.traiders.MainActivity;
import tk.traiders.R;
import tk.traiders.components.article.ViewArticleActivity;

public class ChooseAvatarActivity extends AppCompatActivity {

    private RequestQueue requestQueue;
    private String URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_avatar);
        requestQueue = Volley.newRequestQueue(this);



        Intent intent = getIntent();
        if(intent.hasExtra("userUrl")) {
            URL = intent.getStringExtra("userUrl");
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void avatar_1(View view) {
        updateAvatar(1);
    }

    public void avatar_2(View view) {
        updateAvatar(2);
    }

    public void avatar_3(View view) {
        updateAvatar(3);
    }

    public void avatar_4(View view) {
        updateAvatar(4);
    }

    public void avatar_5(View view) {
        updateAvatar(5);

    }

    public void avatar_6(View view) {
        updateAvatar(6);

    }

    public void avatar_7(View view) {
        updateAvatar(7);

    }

    public void avatar_8(View view) {
        updateAvatar(8);

    }

    public void avatar_9(View view) {
        updateAvatar(9);
    }

    public void avatar_10(View view) {
        updateAvatar(10);
    }

    public void avatar_11(View view) {
        updateAvatar(11);

    }

    public void avatar_12(View view) {
        updateAvatar(12);
    }

    private void updateAvatar(int avatarId){

        StringRequest patchRequest = new StringRequest(Request.Method.PATCH, MainActivity.getUserURL(this),
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(ChooseAvatarActivity.this, "Avatar updated!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ChooseAvatarActivity.this, "An error occured updating avatar!", Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                }
        ) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = MainActivity.getAuthorizationHeader(ChooseAvatarActivity.this);
                return headers != null ? headers : super.getHeaders();
            }

            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("avatar", Integer.toString(avatarId));
                return params;
            }
        };

        requestQueue.add(patchRequest);

    }

    public static int getAvatarDrawableId(int avatar_id){
        int avatar_drawable_id;

        if(avatar_id == 1){
            avatar_drawable_id = R.drawable.avatar_1;
        } else if(avatar_id == 2) {
            avatar_drawable_id = R.drawable.avatar_2;
        } else if(avatar_id == 3) {
            avatar_drawable_id = R.drawable.avatar_3;
        } else if(avatar_id == 4) {
            avatar_drawable_id = R.drawable.avatar_4;
        } else if(avatar_id == 5) {
            avatar_drawable_id = R.drawable.avatar_5;
        } else if(avatar_id == 6) {
            avatar_drawable_id = R.drawable.avatar_6;
        } else if(avatar_id == 7) {
            avatar_drawable_id = R.drawable.avatar_7;
        } else if(avatar_id == 8) {
            avatar_drawable_id = R.drawable.avatar_8;
        } else if(avatar_id == 9) {
            avatar_drawable_id = R.drawable.avatar_9;
        } else if(avatar_id == 10) {
            avatar_drawable_id = R.drawable.avatar_10;
        } else if(avatar_id == 11) {
            avatar_drawable_id = R.drawable.avatar_11;
        } else if(avatar_id == 12) {
            avatar_drawable_id = R.drawable.avatar_12;
        } else {
            avatar_drawable_id = R.drawable.avatar_1;
        }
        return avatar_drawable_id;
    }
}
