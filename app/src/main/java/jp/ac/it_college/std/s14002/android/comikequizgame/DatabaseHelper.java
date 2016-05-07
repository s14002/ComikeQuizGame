package jp.ac.it_college.std.s14002.android.comikequizgame;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by s14002 on 16/04/22.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, "MyTable.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE MyTable" +
            "(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT" +
                ", Pref TEXT" +
                ", City0 TEXT" +
                ", City1 TEXT" +
                ", City2 TEXT" +
                ", City3 TEXT" +
                ", City4 TEXT" +
                ", Clear INTEGER" +
                ")");

        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【東方Project】\n東方幼々夢(紅魔郷など)より\n" +
                "チルノの番号は?','⑨','①','④','⑧','⑨',1);");    // 1
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【東方Project】\n東方幼々夢より\n" +
                "幽々子様の危険度は?','極高','極高','不明','極低','高',0);");   // 2
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【東方Project】\n東方紅魔郷より\n" +
                "魔理沙はこれまで何枚パンを食べた?','13枚','8枚','11枚','13枚','18枚',0);");    // 3
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【東方Project】\n東方紅魔郷より\n" +
                "フランドール・スカーレットの年齢は?','495歳','12歳','495歳','500歳','877歳',0);");    //4
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【東方Project】\n東方永夜抄より\n" +
                "慧音先生は宿題を忘れた生徒（生徒?）に何をする?','頭突き','正拳突き','地獄突き','頭突き','チョップ',0);");    //5
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【東方Project】\n東方幼々夢より\n" +
                "八雲藍の好物は?（難問?）','油揚げ','コロッケ','かき揚げ','唐揚げ','油揚げ',0);"); // 6
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【東方Project】\n博麗霊夢の能力は「空を飛ぶ程度の能力」ですが、\n" +
                "始めの作品の霊夢は飛ぶことができませんでした。\n" +
                "では誰が飛べるようにしたのでしょうか？','玄爺','魔理沙','龍神様(幻想郷で一番偉い人)','玄爺','魅魔',0);");    // 7
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【東方Project】\n紅魔郷のラスボス、レミリア・スカーレット。\n" +
                "以下の中で彼女のスペルカードで無いものはどれ？','スカーレットビハインド','スカーレットデビル','スカーレットマイスタ','スカーレットディスティニー','スカーレットビハインド',0);");    // 8
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【東方Project】\n東方神霊廟に登場する霍青娥の能力は何ですか？','壁をすり抜けられる程度の能力','壁をすり抜けられる程度の能力','永遠に老いない程度の能力','死体を操る程度の能力','寿命を延ばす程度の能力',0);");    // 9
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【東方Project】\n東方花映塚にて一番移動速度の遅い自機キャラクターは誰ですか？','風見幽香','博麗霊夢','八雲紫','ミスティアローレライ','風見幽香',0);");   // 10
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【艦これ】\nこの中で唯一建造時間が違うのはどれ？','鬼怒','長良','古鷹','川内','鬼怒',0);");    // 11
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【艦これ】\n陽炎型8番艦はだれ？','雪風','島風','不知火','雪風','舞風',0);");   // 12
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【艦これ】\nバケツって何？','高速修復材','高速建造材','開発資材','高速遠征材','高速修復材',0);");    // 13
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【艦これ】\n駆逐艦「響」の改二にあたる『Верный（ヴェールヌイ）』。ロシア語ではどんな意味？','信頼できる','冷静である','信頼できる','完璧である','動じない',0);");    // 14
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【艦これ】\n艦隊のアイドル那珂ちゃんを解体した時に手に入る資材は？','燃2弾4鋼11','燃2弾4鋼11','燃2弾2鋼14','燃2弾2鋼12','燃4弾2鋼11',0);");    // 15
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【艦これ】\n戦闘は1つの艦隊ごとに行われます。さて、1つの艦隊には最大何隻軍艦を配備できるでしょうか？','6隻','12隻','8隻','3隻','6隻',0);");   // 16
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【艦これ】\nゲームプレイヤーが最も嫌う戦闘中での完全戦闘不能状態「轟沈」理由は？','二度と逢えなくなる','レベルが1に戻る','二度と逢えなくなる','修理するのに大量の資源が必要','課金アイテムが必要',0);");    // 17
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【艦これ】\n次の艦娘のうち外国生まれは誰？','金剛','金剛','比叡','榛名','霧島',0);");    // 18
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【艦これ】\nＬｖ99の艦娘と契りを交すアップデートが2014年2月14日に行われました。 では、このシステムの名前は？','ケッコンカッコカリ','結婚(仮)','結婚(カリ)','ケッコンカッコカリ','ケッコン(仮)',0);");    // 19
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【艦これ】\n軽巡の正式名称は？','軽巡洋艦','軽巡回艦','軽量型巡査艦','軽巡洋艦','軽空母巡洋艦',0);");   // 20
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【化物語シリーズ】\n化物語八九寺真宵は、愛はコンビニでいくらで売られていると言いましたか？','298円','498円','298円','398円','198円',0);");    // 21
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【化物語シリーズ】\n忍野忍について｡忍という名前を貰う前の名前は？','ｷｽｼｮｯﾄ･ｱｾﾛﾗｵﾘｵﾝ･ﾊｰﾄｱﾝﾀﾞｰﾌﾞﾚｰﾄﾞ','ｱｾﾛﾗｼｮｯﾄ･ｱﾝﾀﾞｰｷｽﾊｰﾄ･ｵﾘｵﾝﾌﾞﾚｰﾄﾞ','ｷｽｼｮｯﾄ･ｴﾘｻﾞﾍﾞｰﾄ･ｱﾚｷｻﾝﾀﾞｰﾌﾞﾚｲﾄﾞ','ｷｽｼｮｯﾄ･ｱｾﾛﾗｵﾘｵﾝ･ﾊｰﾄｱﾝﾀﾞｰﾌﾞﾚｰﾄﾞ','ｱｾﾛﾗｼｮｯﾄ･ｱﾚｷｻﾝﾀﾞｰ･ｴﾘｻﾞﾍﾞｰﾄﾌﾞﾚｲﾄﾞ',0);");   // 22
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【化物語シリーズ】\n次のうち蝸牛に迷ったのは誰でしょう？','八九寺真宵','千石撫子','神原駿河','羽川翼','八九寺真宵',0);");    // 23
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【化物語シリーズ】\n忍野メメがいつもいるのは何階でしょう？','4階','2階','3階','4階','5階',0);");    // 24
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【化物語シリーズ】\n主人公が無敵になったのは何故？','吸血鬼に襲われたから','吸血鬼に襲われたから','不死鳥に襲われたから','蛇に襲われたから','しでの鳥に襲われたから',0);");    // 25
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【化物語シリーズ】\n阿良々木くんの父親と母親の職業は？','警察官','医者','警察官','俳優','弁護士',0);");   // 26
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【化物語シリーズ】\n斧乃木余接の技で正しいのはどれ？','例外の方が多い規則(アンリミテッドルールブック)','制限の方が少ない規則(アンリミテッドルールブック)','無制限の方が多い規則(アンリミテッドルールブック)','原則の方が少ない規則(アンリミテッドルールブック)','例外の方が多い規則(アンリミテッドルールブック)',0);");    // 27
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【化物語シリーズ】\n左手が「雨降りの悪魔(レイニー・デヴィル)」という怪異と化してたのは誰？','神原駿河','阿良々木暦','戦場ヶ原ひたぎ','神原駿河','千石撫子',0);");    // 28
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【化物語シリーズ】\n『蛇切縄』という、蛇の怪異の呪いをかけられたのは誰？','千石撫子','千石撫子','神原駿河','羽川翼','戦場ヶ原ひたぎ',0);");    // 29
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【化物語シリーズ】\n戦場ヶ原ひたぎが体重を奪われた(正確には差し出した)怪異はどれ？','おもし蟹','キョンシー','おもし蟹','蛞蝓豆腐(なめくじどうふ)','苛虎',0);");   // 30
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【東京喰種トーキョーグール】\n主人公である金木研の親友の名前は何？','永近英良','永近英良','永近秀友','永近秀重','永近英夫',0);");    // 31
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【東京喰種トーキョーグール】\n東京喰種トーキョーグールに出てくるインコの名前は？','ヘタレ','ウマノクソ','ヨワムシ','ヘタレ','マヌケ',0);");   // 32
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【東京喰種トーキョーグール】\n金木が好きな本の作者は？','高槻泉','高槻泉','高橋泉','高倉泉','高木泉',0);");    // 33
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【東京喰種トーキョーグール】\nカネキの赫子は誰に似てる？','リゼ','月山','トーカ','リゼ','ニコ',0);");    // 34
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【東京喰種トーキョーグール】\nカネキの赫者姿は何に影響された？','ムカデ','蛇','ムカデ','サソリ','ザリガニ',0);");    // 35
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【東京喰種トーキョーグール】\nカネキが倒してないのは？','鯱','ヤモリ','月山','アヤト','鯱',0);");   // 36
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【東京喰種トーキョーグール】\n喰種捜査官亜門鋼太郎の好きな食べ物は？','ドーナツ','ドーナツ','ポッキー','キムチ鍋','チンゲン菜',0);");    // 37
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【東京喰種トーキョーグール】\nリョーコの娘は？','ヒナミ','リゼ','トーカ','ヒナミ','アキラ',0);");    // 38
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【東京喰種トーキョーグール】\n捜査官の使う喰種と戦うための武器は何？','クインケ','クインカ','クインキ','クンカクンカ','クインケ',0);");    // 39
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【東京喰種トーキョーグール】\nトーカの赫子は何？','羽赫','羽赫','甲赫','鱗赫','尾赫',0);");   // 40
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【新世紀エヴァンゲリオン】\nA.T.フィールドは何の略?','ABSOLUTE TERROR FIELD','ANTI TERROR FIELD','ABSOLUTE THROUGH FIELD','ABSOLUTELY TERROR FIELD','ABSOLUTE TERROR FIELD',0);");    // 41
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【新世紀エヴァンゲリオン】\n「エヴァンゲリオン」はギリシャ語で何を意味するか','福音','人造','福音','使徒','救世主',0);");   // 42
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【新世紀エヴァンゲリオン】\nEVA零号機のパイロットは？','綾波レイ','碇シンジ','式波（惣流）・アスカ・ラングレー','綾波レイ','渚カヲル   ',0);");    // 43
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【新世紀エヴァンゲリオン】\nエヴァンゲリヲンの舞台はどこ？','第3新東京市','第2新東京市','第3新東京市','第4新東京市','第5新東京市',0);");    // 44
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【新世紀エヴァンゲリオン】\nEVA初号機のパイロットは？','碇シンジ','碇シンジ','式波（惣流）・アスカ・ラングレー','渚カヲル','真希波マリ',0);");    // 45
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【新世紀エヴァンゲリオン】\nアスカはセカンドチルドレンとしてどこの国から日本にやって来たか？','ドイツ','アメリカ','イギリス','フランス','ドイツ',0);");   // 46
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【新世紀エヴァンゲリオン】\n葛城ミサトがペットとして飼っているペンギンの名前は？','ペンペン','グァグァ','ピンピン','ペンペン','ペン君',0);");    // 47
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【新世紀エヴァンゲリオン】\n碇シンジが常に持ち歩いているカセットプレイヤーは誰から貰った物？','碇ゲンドウ','葛城ミサト','綾波レイ','渚カヲル','碇ゲンドウ',0);");    // 48
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【新世紀エヴァンゲリオン】\n第3の使徒の名前は？','サキエル','レリエル','サキエル','シャムシエル','ラミエル',0);");    // 49
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【新世紀エヴァンゲリオン】\nイスラフェルは第何の使徒？','第7使徒','第1使徒','第3使徒','第5使徒','第7使徒',0);");   // 50
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【妖怪ウォッチ】\nコマさんの大好物は？','ソフトクリーム','おまんじゅう','ケーキ','プリン','ソフトクリーム',0);");    // 51
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【妖怪ウォッチ】\nウィスパーは何を使って妖怪の情報を調べている？','妖怪パッド','妖怪フォン','妖怪パッド','妖怪パソコン','妖怪タブレット',0);");   // 52
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【妖怪ウォッチ】\nコマさんの弟の名前は？','コマじろう','コマのすけ','コマじろう','コマたろう','コマごろう',0);");    // 53
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【妖怪ウォッチ】\nジバニャンは飼い猫の時に何と呼ばれていた？','あかまる','あかまる','ニャンまる','タマ','コロ',0);");    // 54
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【妖怪ウォッチ】\n「ビクトリアーン！」と叫ぶエクササイズ好きの妖怪は？','ブリー隊長','グリー隊長','ベリー隊長','ビリー隊長','ブリー隊長',0);");    // 55
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【妖怪ウォッチ】\n「ゲラゲラポーのうた」を歌っているグループはキング・○○○○ソーダ？','クリーム','クリーム','ハチミツ','カルピス','メロン',0);"); // 56
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【妖怪ウォッチ】\n「そうじゃナイよ！」が口癖の妖怪「認MEN」は何人組？','3','5','3','4','2',0);");    // 57
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【妖怪ウォッチ】\nノガッパが首から下げている水筒の色は何色？','赤','赤','白','青','紫',0);");    // 58
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【妖怪ウォッチ】\n第40話「妖怪ベストテン」で1位に選ばれた妖怪は？','ダイヤニャン','ウィスパー','コマさん','ジバニャン','ダイヤニャン',0);");    // 59
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【妖怪ウォッチ】\nジバニャンが好きなアイドルグループは？','ニャーKB','ニャニャくろ','ニャーKB','おニャン子クラブ','ニャー娘。',0);");   // 60
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【ソードアート・オンライン】\nソードアートアート・オンラインの主人公の名前は？','キリト','カヤバ','エギル','キリト','クライン',0);");    // 61
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【ソードアート・オンライン】\n使い魔蘇生アイテムの名前は？','プネウマの花','コウシの花','ランの花','ポルネの花','プネウマの花',0);");   // 62
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【ソードアート・オンライン】\nSAOの妹的存在のシリカの使い魔の名前は？','ピナ','ヒナ','フィナ','ピア','ピナ',0);");    // 63
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【ソードアート・オンライン】\nこのアニメ内で存在しないものは？（アインクラッド編）','アエルロト','アエルロト','アスナ','ヒースクリフ','シノン',0);");    // 64
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【ソードアート・オンライン】\nGGOにおける最強ガンナー決定戦のBoBは何の略？','バレット･オブ･バレッツ','バレット･オブ･バレット','バレッツ･オブ･バレット','バレッツ･オブ･バレッツ','バレット･オブ･バレッツ',0);");    // 65
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【ソードアート・オンライン】\n《ビーストテイマー》のシリカの使い魔の種族名は？','フェザーリドラ','フェザーリドラ','フリーベン','ブルーフラグス','リザーフェドラ',0);");   // 66
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【ソードアート・オンライン】\nｿｰﾄﾞｱｰﾄ･ｵﾝﾗｲﾝ6より出題。 アスナは《ＡＬＯ》内ではどの種族に属しているでしょう。','水妖精族(ウンディーネ)','猫妖精族(ケットシー)','風妖精族(シルフ)','工匠妖精族(レプラコーン)','水妖精族(ウンディーネ)',0);");    // 67
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【ソードアート・オンライン】\nｿｰﾄﾞｱｰﾄ･ｵﾝﾗｲﾝ4でｷﾘﾄとﾘｰﾌｧが象水母邪神につけた名前は？','トンキー','コンキー','トンキー','ノンキー','リンキー',0);");    // 68
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【ソードアート・オンライン】\nシノンが使っているライフルの名前は？','PGM･ｳﾙﾃｨﾏﾗﾃｨｵ･ﾍｶｰﾄ?','PGM･ｳﾙﾃﾞﾏﾗﾃｨｵ･ﾍｶｰﾄ?','PGM･ｳﾙﾃｨﾏﾗﾃｨｵ･ﾍｶｰﾄ?','PGM･ｱﾝﾁﾏﾃﾘｱﾙ･ﾍｶｰﾄ?','PGM･ｱﾝﾄﾏﾃﾘｱﾙ･ﾍｶｰﾄ?',0);");    // 69
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【ソードアート・オンライン】\nアスナがALOで出会った、「ユウキ」の本名は？ ','紺野木綿季','紺野木綿季','憂沙乃夏希','朝田 詩乃','結城 明日奈',0);");   // 70
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【おそ松さん】\n次の内いつも口を開けているのは誰？','十四松','おそ松','トド松','十四松','イヤミ',0);");    // 71
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【おそ松さん】\nおそ松さん14話で風邪をひいていましたが最初に風邪を移されたのは誰？','おそ松','一松','チョロ松','おそ松','カラ松',0);");   // 72
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【おそ松さん】\nおそ松さん25話でホームランを打った人がいましたが誰でしょうか','十四松','十四松','トト子','モブキャラ','一松',0);");    // 73
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【おそ松さん】\nトド松が働いていた店名はどれ？','スタバァコォヒィー','スタバァバックス','スタバァバァックス','スターバックス','スタバァコォヒィー',0);");    // 74
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【おそ松さん】\n長男、次男、三男の順番を選びなさい','おそ松、カラ松、チョロ松','おそ松、カラ松、チョロ松','おそ松、チョロ松、カラ松','チョロ松、一松、おそ松',' チョロ松、カラ松、一松',0);");    // 75
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【おそ松さん】\nおそ松さん21話「麻雀」でチョロ松が上がれないのはなぜ？','自分の目に当たり牌が出てるから','オープンリーチをしてるから','自分の目に当たり牌が出てるから','そもそも上がりたくないから','役満縛りだから',0);");   // 76
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【おそ松さん】\nおそ松さん24話でおそ松が十四松を蹴ったのはなぜ？','寿司を落としたため','十四松を蹴った際「ボウェ」をしてくれると思ったから','チョロ松への嫉妬を解消しようとしたため','寿司を落としたため','パチンコで負けてイラついたため',0);");    // 77
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【おそ松さん】\nおそ松さん24話でトト子はどこの国へ語学留学をしに行った？','シンガポール','シンガポール','中国','アメリカ','韓国',0);");    // 78
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【おそ松さん】\n６人がそろって着ない服は？','チェック','つなぎ','パーカー','チェック','スーツ',0);");    // 79
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【おそ松さん】\nエスパーニャンコが出た時忘れられたのは？','カラ松','十四松','一松','おそ松','カラ松',0);");   // 80
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【進撃の巨人】\n主人公、エレン・イェーガーの「イェーガー」のドイツ語の意味は？','狩人','賢者','軍人','番犬','狩人',0);");    // 81
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【進撃の巨人】\nこの世界の壁の外にウヨウヨいる巨人の弱点は？','うなじ','こめかみ','みぞおち','うなじ','わきばら',0);");   // 82
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【進撃の巨人】\n3重の壁 内側からの正しい並び順を選べ','シーナ ローゼ マリア','ローゼ シーナ マリア','シーナ ローゼ マリア','マリオ ローバ シーフ','マリア シーナ ローゼ',0);");    // 83
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【進撃の巨人】\n特別編 ﾘヴァｲ兵士長にて 人類最強の兵士ﾘヴァｲ兵士長の戦力はどれほどか','一個旅団並み','一個旅団並み','王国騎士団の一個大隊並み','調査兵団の一個小隊並み','9道力',0);");    // 84
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【進撃の巨人】\n駐屯兵団の精鋭から見た ﾐｶｻの戦力(働き)は何と等価?','並みの兵士100人','精鋭50人','並みの兵士50人','並みの兵士100人','精鋭100人',0);");    // 85
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【進撃の巨人】\n進撃の巨人で戦いには欠かせない武器の名称は？','立体機動装置','甲殻機動装置','立体機動装置','高速機動装置','飛行可動装置',0);");   // 86
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【進撃の巨人】\n凄まじい突進で壁の扉を突き破った巨人はなんと呼ばれている？','鎧の巨人','女型の巨人','獣の巨人','超大型巨人','鎧の巨人',0);");    // 87
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【進撃の巨人】\nミカサは何人？','東洋人','原始人','東洋人','黒人','宇宙人',0);");    // 88
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【進撃の巨人】\n巨人の中で存在しないのは？','ニーナ','ビーン','ニーナ','ソニー','奇行種',0);");    // 89
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【進撃の巨人】\n巨人はいつ頃、現れたのか？','107年前から','人類が存在するよりもはるか昔からいる','70年前','107年前','170年前',0);");   // 90
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【Fate】\nセイバーのマスターは誰？','衛宮士郎','衛宮士郎','衛宮士朗','衛宮志朗','衛宮志郎',0);");    // 91
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【Fate】\n最狂のｻｰｳﾞｧﾝﾄ、バーサーカーの正体は？','ヘラクレス','ペルセウス','ゼウス','ヘラクレス','フレイア',0);");   // 92
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【Fate】\n士郎が投影した剣の名は？','勝利すべき黄金の剣','約束された黄金の剣','勝利すべき黄金の剣','約束すべき王の剣','勝利すべき約束の剣',0);");    // 93
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【Fate】\n前回から残っているアーチャーの正体は？','ギルガメッシュ','ギルガメイシュ','ギルガメッシュ','ギルカメッシュ','キルガメッシュ',0);");    // 94
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【Fate】\nセイバーの持つ聖剣の名前は?','エクスカリバー','ゲイボルク','エクスカリバー','ゼルレッチ','ベルレフォーン',0);");    // 95
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【Fate】\nアヴェンジャーの真名はなんでしょう。','アンリマユ','アンザイユウコ','マタ・ハリ','アンリマユ','ヤスダマコ',0);");   // 96
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【Fate】\n第五次のライダーの真名はなんでしょう。','メドゥーサ','メドゥーサ','イスカンダル','アンドロメダ','チンギス・カン',0);");    // 97
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【Fate】\n破戒すべき全ての符','ルールブレイカー','ルールブレイク','ルールブレイカー','ルールとマナーを守ろう','ルール・ブレイカー',0);");    // 98
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【Fate】\n全て遠き理想郷','アヴァロン','ザシャロガン','マカロニア','アヴァロン','アルカディア',0);");    // 99
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4, Clear) values ('【Fate】\n十二の（　　）「ゴッド・ハンド」','試練','生命','教訓','試練','偉業',0);");   // 100
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}