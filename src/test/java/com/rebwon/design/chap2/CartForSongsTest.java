package com.rebwon.design.chap2;

import static org.assertj.core.api.Assertions.assertThat;

import com.rebwon.design.chap2.practice.CartForSongs;
import com.rebwon.design.chap2.practice.DiscountMode.None;
import com.rebwon.design.chap2.practice.DiscountMode.OnSale;
import com.rebwon.design.chap2.practice.DiscountMode.TodayEvent;
import com.rebwon.design.chap2.practice.Song;
import org.junit.jupiter.api.Test;

class CartForSongsTest {

    @Test
    void integrationTest() {
        Song s1 = new Song();
        s1.setMode(new None());

        Song s2 = new Song();
        s2.setMode(new None());

        Song s3 = new Song();
        s3.setMode(new OnSale());

        Song s4 = new Song();
        s4.setMode(new TodayEvent());

        CartForSongs songs = new CartForSongs();

        songs.add(s1);
        songs.add(s2);
        songs.add(s3);
        songs.add(s4);

        assertThat(songs.calculateTotalPrice()).isEqualTo(36.0);
    }
}