package com.leandro.marvelapp.home;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.leandro.marvelapp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CharacterListAdapter extends RecyclerView.Adapter<CharacterListAdapter.CharacterViewHolder> {

    private final List<Character> data = new ArrayList<>();
    private final CharacterSelectedListener characterSelectedListener;

    public CharacterListAdapter(ListViewModel viewModel, LifecycleOwner lifecycleOwner, CharacterSelectedListener characterSelectedListener) {
        this.characterSelectedListener = characterSelectedListener;
        viewModel.getCharacters().observe(lifecycleOwner, characters -> {
            data.clear();
            if (characters != null) {
                data.addAll(characters);
            }
            notifyDataSetChanged();
        });
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_characters_list_item, parent, false);
        return new CharacterViewHolder(view, characterSelectedListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public long getItemId(int position) {
        return data.get(position).getId();
    }

    static final class CharacterViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.character_image)
        ImageView characterImageView;
        @BindView(R.id.character_name)
        TextView characterNameTextView;
        Context context;
        private Character character;

        CharacterViewHolder(View itemView, CharacterSelectedListener characterSelectedListener) {
            super(itemView);
            this.context = itemView.getContext();
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> {
                if (character != null) {
                    characterSelectedListener.onCharacterSlected(character);
                }
            });
        }

        void bind(Character character) {
            this.character = character;
            String imageUrl = character.getThumbnail().getPath() + "/detail." + character.getThumbnail().getExtension();
            Glide.with(context).load(imageUrl).into(characterImageView);
            characterNameTextView.setText(character.getName());
        }
    }
}
