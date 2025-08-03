package com.example.android_assignment_1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_assignment_1.post_recycler_view.Post;
import com.example.android_assignment_1.post_recycler_view.adapter.PostAdapter;

import java.util.ArrayList;
import java.util.List;

public class PostRecycleView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_post_recycle_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView postsRecyclerView = findViewById(R.id.posts_recycler_view);

        List<Post> posts = generateFakePosts();
        PostAdapter adapter = new PostAdapter(posts);
        postsRecyclerView.setAdapter(adapter);
    }

    private List<Post> generateFakePosts() {
        List<Post> posts = new ArrayList<>();

        int[] postImages = {R.drawable.post_image_1, R.drawable.post_image_2, R.drawable.post_image_3};

        String[] userNames = {"Unblast", "Creative Design", "Code Savvy", "Art Daily", "Tech News", "Digital Muse", "Pixel Perfect", "Web Works", "Design Hub", "Code Master"};
        String[] postTexts = {"Buckle up, because change is coming to WordPress", "Tips and tricks for modern UI design", "How to build a responsive app with Android", "The power of composition in photography", "New smartphone release from XYZ company", "Exploring the depths of the universe with JS", "A guide to clean code principles", "The future of augmented reality in mobile", "Mastering typography in web design", "The latest trends in backend development"};
        String[] postLinks = {"http://unblast.com/color-schemes", "http://design.com/ui-tips", "http://codesavvy.com/responsive-android", "http://artdaily.com/composition", "http://technews.com/xyz-phone", "http://digimuse.com/space", "http://cleancode.com/guide", "http://ar.com/future", "http://typo.com/mastery", "http://backend.com/trends"};

        for (int i = 0; i < 100; i++) {
            String userName = userNames[i % userNames.length];
            String postMetadata;
            if (i % 2 == 0) {
                postMetadata = (i / 2) + " hrs • ";
            } else {
                postMetadata = (i / 2) + " days • ";
            }
            String postText = postTexts[i % postTexts.length];
            String postLink = postLinks[i % postLinks.length];
            int likesCount = (i * 10) + 12;
            int sharesCount = (i % 5) + 1;

            int postImageResId = postImages[i % postImages.length];

            posts.add(new Post(userName, postMetadata, postText, postLink, postImageResId, likesCount, sharesCount));
        }
        return posts;
    }
}