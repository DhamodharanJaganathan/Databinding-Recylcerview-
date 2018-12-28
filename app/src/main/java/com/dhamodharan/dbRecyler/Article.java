package com.dhamodharan.dbRecyler;


import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class Article extends BaseObservable {

  private String title;
  private String excerpt;
  private boolean highlight;
  private String imageUrl;
  private int commentsNumber;
  private boolean read;

  public Article(String title, String excerpt, boolean highlight, String imageUrl,
      int commentsNumber) {
    this.title = title;
    this.excerpt = excerpt;
    this.highlight = highlight;
    this.imageUrl = imageUrl;
    this.commentsNumber = commentsNumber;
    this.read = false;
  }

  @BindingAdapter({"image"})
  public static void loadImage(ImageView view, String url) {

    GlideApp.with(view.getContext())
        .load("https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_92x30dp.png")
        .skipMemoryCache(true)
        .diskCacheStrategy(DiskCacheStrategy.NONE).into(view);
  }

  @Bindable
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
    notifyPropertyChanged(BR.title);
  }

  public String getExcerpt() {
    return excerpt;
  }

  public void setExcerpt(String excerpt) {
    this.excerpt = excerpt;
  }

  public boolean isHighlight() {
    return highlight;
  }

  public void setHighlight(boolean highlight) {
    this.highlight = highlight;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public int getCommentsNumber() {
    return commentsNumber;
  }

  public void setCommentsNumber(int commentsNumber) {
    this.commentsNumber = commentsNumber;
  }

  public boolean isRead() {
    return read;
  }

  public void setRead(boolean read) {
    // change title of already read article:
    if (read && !this.read) {
      setTitle("READ: " + getTitle());
    }

    this.read = read;
  }

  public View.OnClickListener onReadMoreClicked() {
    return view -> {
      Toast.makeText(view.getContext(), "Opens article detail", Toast.LENGTH_SHORT).show();
      setRead(true);
    };
  }

  public View.OnClickListener onCommentsClicked() {
    return view -> Toast.makeText(view.getContext(), "Opens comments detail", Toast.LENGTH_SHORT).show();
  }
}

