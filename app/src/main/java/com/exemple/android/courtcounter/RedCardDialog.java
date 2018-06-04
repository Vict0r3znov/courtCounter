package com.exemple.android.courtcounter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Objects;

public class RedCardDialog extends AppCompatDialogFragment {
    EditText editText ;
    PlayerName redPlayerName;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
       AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
       LayoutInflater inflater = Objects.requireNonNull(getActivity()).getLayoutInflater();
       @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.yellow_red_card_dialogxml,null);
       editText = view.findViewById(R.id.playerName);
        ImageView image = view.findViewById(R.id.addPlayer);
        image.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
       builder.setView(view)
               .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {

                   }
               })
               .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       String playerName = editText.getText().toString();
                       redPlayerName.getRedName(playerName);
                   }
               });
       return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            redPlayerName = (PlayerName) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement ClassCastException");
        }
    }

    public interface PlayerName {
        void getRedName(String name);
    }
}
