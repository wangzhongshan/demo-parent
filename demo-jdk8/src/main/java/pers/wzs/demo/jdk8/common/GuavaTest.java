package pers.wzs.demo.jdk8.common;

import com.google.common.base.Splitter;

/**
 * Created by wangzhongshan on 2017/12/22.
 */
public class GuavaTest {
    public static void main(String[] args) {
        Iterable<String> split = Splitter.fixedLength(21)
                                         .split("前朝旧事，大唐盛景，鸿篇巨制！不一样的历史演绎，生出了许多对于人性的思考。巫术、幻象都是大多也是心性写照，猫出的问题，去猫身上找；人身上的问题，去人身上找。不论杨贵妃是否具有胡人血统，她倾国倾城就好了~空海和尚和白乐天在盛世长安城里寻找线索，是《阴阳师》里安倍晴明和源博雅在平安京断案驱邪，奇妙的场景交织。梦枕貘的想象力太牛了。我会重新去读李白的《清平调》和白居易的《长恨歌》。电影看得意犹未尽，电影篇幅还是显得不够。");
        for (String s : split) {
            System.out.println(s);
        }

    }
}
