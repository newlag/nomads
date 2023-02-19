package com.hakaton.nomads.ui.fragments.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.hakaton.nomads.R
import com.hakaton.nomads.databinding.FragmentNewsCardBinding
import com.hakaton.nomads.ui.fragments.BaseSecondaryFragment
import com.hakaton.nomads.utils.GlideWrapper

class NewsMoreFragment: BaseSecondaryFragment() {

    private lateinit var binding: FragmentNewsCardBinding

    private val images = listOf(
        R.drawable.ic_news,
        R.drawable.ic_news_2,
        R.drawable.ic_news_3
    )

    private val titles = listOf(
        "Стартовал Международный трек Программы Студтуризм",
        "На Всероссийском форуме «СТУДТУРИЗМ - 2023» 150 представителей вузов и нашего сообщества из разных регионов разработали комплексную стратегию развития внутреннего молодежного туризма в России на 2023 год",
        "На Всероссийском форуме «СТУДТУРИЗМ - 2023» 150 представителей вузов и нашего сообщества из разных регионов разработали комплексную стратегию развития внутреннего молодежного туризма в России на 2023 год"
    )

    private val tags = listOf(
        listOf("#Студтуризм", "#СТУДТУРИЗМ2022", "#МеждународныйТрек"),
        listOf("#Студтуризм", "#СТУДТУРИЗМ2022", "#ФорумСтудтуризм"),
        listOf("#Студтуризм", "#СТУДТУРИЗМ2022", "#Интервьюсректором")
    )

    private val description = listOf(
        "В сентябре 2022 года состоялся пилотный этап международного трека Программы молодежного и студенческого туризма.\n" +
                "\n" +
                "В период с 4 по 9 сентября г. Москву посетили делегация из Республики Узбекистан в составе 6 студентов Международного университета туризма и культурного наследия «Шелковый путь». Студенты разместились на базе общежития ФГБОУ ВО «Российский государственный университет туризма и сервиса», для них была организована культурно-познавательная программа, в том числе посещение музея «Парк Победы», а также образовательная программа в виде посещения лекций в принимающей образовательной организации, а также знакомство и общение с преподавателями и студентами. В рамках визита делегации в г. Москву состоялась также встреча с представителями Минобрнауки России.\n" +
                "\n" +
                "В свою очередь, визит студентов ФГБОУ ВО «Российский государственный университет туризма и сервиса» в Республику Узбекистан прошел в период с 12 по 16 декабря 2022 г.\n" +
                "Далее подобные двухсторонние обмены студентов в рамках международного трека Программы планируется реализовывать на постоянной основе.\n" +
                "\n" +
                "Студенты разместились на базе общежития Международного университета туризма и культурного наследия «Шелковый путь» (г. Самарканд, Республика Узбекистан), для них была организована культурно-познавательная программа, в том числе посещение обсерватории Мирзо-Улугбека, ковровой фабрики «Худжум», а также мастер-класс по гончарному искусству.\n" +
                "\n" +
                "Кроме того, молодые люди приняли участие в образовательных мероприятиях, организованных принимающим университетом, в виде посещения лекций «Самарканд-Бухара на перекрестке Великого Шелкового пути. Самарканд-перекресток туристических маршрутов», тренинга «Анализ развития международного туризма между Россией и Узбекистаном», а также познакомились со специалистами туриндустрии и обсудили специфику работы отельеров в рамках визитов в новые гостиницы г. Самарканда: Samarkand Regency Amir Temur и Movenpick.\n" +
                "\n" +
                "ОТЗЫВЫ УЧАСТНИКОВ:\n" +
                "\n" +
                "Григорьева Алёна, Высшая школа сервиса, 1 курс: «Я очень рада, что университет дал мне возможность поехать в Узбекистан, так как я давно мечтала об этом. Это было невероятное путешествие, которое очень сильно повлияло на мою жизнь. Поездка помогла мне найти новых друзей, изучить культуру Узбекистана и насладиться моментом».\n" +
                "Соловская Анна, Высшая школа туризма и гостеприимства, 3 курс: «Никогда бы не подумала, что жизнь даст мне возможность побывать в Узбекистане. Я безумно рада, что смогла насладиться колоритом этой страны. Узбекский плов – это что-то божественное!!!! Жду с нетерпением свободного времени, чтобы вернуться снова в эту страну».\n" +
                "Ашурова Замира, Высшая школа бизнеса, менеджмента и права, 3 курс: «Все свое детство я провела в Узбекистане, поэтому эта поездка дала мне шанс вдохнуть воздух прошлого и стать еще счастливее. Проходя по улицам города Самарканд, я чувствовала себя как дома. Мне было спокойно на душе и это так прекрасно!»\n" +
                "Большеданов Владислав, Высшая школа туризма и гостеприимства, 3 курс: «Я вообще не думал, что смогу полететь в Узбекистан, так как возможность выпадала не всем. Но мне повезло, я все-таки полетел в эту страну, и я очень рад! Никогда в жизни не пробовал такую вкусную самсу и такой сытный плов!»",
        "С 13 по 15 декабря 2022 года прошел Всероссийский форум «СТУДТУРИЗМ-2023», который объединил более 150 человек из разных регионов России, которые активно вовлечены в развитие внутреннего молодежного и студенческого туризма в стране.\n" +
                "\n" +
                "На форум приехали как представители университетов, которые активно принимали гостей в этом сезоне, так и студенты нашего сообщества «Студтуризм», которое образовалось после форума «Машук» в августе.\n" +
                "Организатором форума выступила команда Программы молодежного и студенческого туризма, которая подготовила для участников активную насыщенную программу.\n" +
                "\n" +
                "Главными целями проведения форума мы ставили для себя:\n" +
                "\n" +
                "1.Познакомить организаторов с ключевыми векторами деятельности проекта Студтуризм, дать понимание миссии программы и ценностную составляющую и укрепить межвузовские партнерские отношения\n" +
                "2.Детально разобрать успешные кейсы прошедшего сезона, дать участникам инструменты для разработки туристических маршрутов и полезных программ по всем направлениям, в рамках которых реализуется Программа Студтуризм: это культурно-познавательное, научно-популярное и профориентационное.\n" +
                "3.А также дать эффективные инструменты PR- и медиа- продвижения для популяризации и привлечения новых туристических потоков молодёжи в свои регионы.\n" +
                "\n" +
                "Нетворкинг после официального открытия форума позволил участникам из регионов чуть ближе познакомиться друг с другом и понять, что одни «не одни» развивают студенческий туризм, а также обменяться опытом и сформировать общее понимание и видение развития Программы молодежного и студенческого туризма.\n" +
                "\n" +
                "14 декабря в Доме Молодёжи в Манеже на Всероссийском студенческом форуме «Твой Ход — 2022» участники форума присутствовали на панельной дискуссии «Трансформация смыслов путешествий по России: новые возможности и ценности полезных поездок «Больше, чем путешествие», где выступили ведущие эксперты в сфере молодёжного туризма.\n" +
                "На встречу были приглашены эксперты в области туризма, в том числе депутат Государственной Думы Федерального собрания Российской Федерации VIII созыва, первый заместитель председателя комитета Государственной Думы по науке и высшему образованию Ксения Горячева, министр кадровой и молодёжной политики Нижегородской области Сергей Бочаров, заведующая кафедрой маркетинга и сервиса Новосибирского государственного технического университета Марина Цой, врио директора Департамента государственной молодёжной политики и воспитательной деятельности Министерства науки и высшего образования РФ Александр Ведехин, руководитель направления развития АНО «Россия — страна возможностей» Иван Шулюпин.\n" +
                "\n" +
                "После панельной дискуссии участникам форума предстояло разбиться на группы по каждому из направлений, предложить гипотезы и идеи, описать методологию разработки туристических маршрутов и определить для себя инструменты развития внутреннего молодежного туризма в России, которые они берут в работу в следующем году.\n" +
                "\n" +
                "Подводя итоги форума, мы точно можем сказать, что:\n" +
                "\n" +
                "1.С участниками сессии разобраны основополагающие элементы работы проекта Студтуризм, его наполнение, ценностная составляющая и глобальные цели\n" +
                "2.В форматах групповой и индивидуальной работы сформированы идеи по развитию научного, профориентационного и культурного направления программы для каждого из вузов\n" +
                "3.Через формы дискуссии и командной работы произошел нетворкинг среди организаторов программы, сформированы идеи для межрегиональных коллабораций\n" +
                "4.Произошло личное вовлечение каждого из организаторов в активную деятельность в Студтуризме, разобраны основные запросы и инициативы каждого из участников\n" +
                "\n" +
                "Несколько отзывов от участников Форума Студтуризм-2023:\n" +
                "\n" +
                "Загайнов Денис: «Северный (Арктический) федеральный университет им.М.В.Ломоносова благодарит организаторов форума, а коллег за конструктивное и очень интересное общение. Уверены, что все идеи воплотятся в проекты!\n" +
                "А пока приглашаем к нам, в Арктику! У нас морозно, но северяне всегда тепло встречают гостей! :)»\n" +
                "\n" +
                "Кузнецова Валерия: «Томский госуниверситет благодарит всех коллег за прекрасный форум! Мы добрались утром домой и уже включились в рабочий процесс:)\n" +
                "Очень приятно было пообщаться, поделиться не только полезным опытом, но и энергией, зарядом и мотивацией!\n" +
                "Отдельное признание всем, кто причастен к организации форума. Вы - герои!\n" +
                "Вспоминается фраза: \"мамы как пуговки - на них все держится\". Так вот, вы в данном случае - те самые мамы. На вас все держится\n" +
                "Приглашаем всех в гости. Несмотря на холодную погоду - встретим вас с теплотой широкой сибирской души!»\n" +
                "\n" +
                "Дарья Потехина: «Всем огромное спасибо за шикарно проведенное время после таких 3 дней осознаешь, какой у нас большой проект, и невероятная команда по всей России отдельная благодарность команде организаторов! Вы невероятные герои))\n" +
                "Дарья, Екатеринбург,УрФУ\n" +
                "До встречи на Урале»\n" +
                "\n" +
                "Тамирхан Хасуев: «Коллеги всем доброго утра, было приятно всеми познакомиться. Спасибо организаторам за возможность друг с другом познакомиться. Огромное всем спасибо. Жду всех на гостеприимной Чеченской земле».\n" +
                "\n" +
                "Форум «СТУДТУРИЗМ-2023» получился очень душевным, что сплотило коллег организационных комитетов из разных регионов и университетов, и при этом эффективным, касательно инструментов, которые они увезли с собой внедрять в развитие молодежного туризма в России.",
        "Как будет развиваться студенческий туризм в Башкортостане рассказал в своем интервью И.о. ректора БашГУ Вадим Захаров.\n" +
                "\n" +
                "– Ваш вуз является участником Программы молодежного и студенческого туризма. Расскажите, как вообще прошел сезон? Сколько всего путешественников у вас побывало?\n" +
                "Башкирский государственный университет (БашГУ) также принимает гостей второй год подряд. В прошлом году вуз посетили студенты из Нижнего Новгорода, Самары и Тюмени. В этом году вуз посетила организованная группа из Мордовского государственного университета\n" +
                "\n" +
                "– А сколько вы отправили своих студентов в путешествия?\n" +
                "Более 150 студентов посетили Южный Урал. Туристы знакомились с тремя заповедниками, посещают объекты природного и культурного наследия, музейно-демонстрационный комплекс «Шульган-Таш», Капову пещеру, а также учились ездить верхом и стрелять из лука.\n" +
                "\n" +
                "– Программа Студтуризм реализуется по 3-м направлениям: это культурно-познавательное, научно-популярное и профориентационное. Какое направление наиболее реализовано сейчас в вашем университете?\n" +
                "Мы в БашГУ второй год подряд реализуем культурно-познавательный трек. Молодые люди посетили музеи, культурные центры столицы, а также природные памятники: самый большой родник в России Красный ключ, Красные скалы, горы Стерлитамакские Шиханы, Серпиевский пещерный град, Идрисовскую пещеру с посещением музея Салавата Юлаева и источника Кургазак и многое другое.\n" +
                "\n" +
                "– По указу Президента РФ сейчас в России объявлено десятилетие науки и технологий с целью привлечения талантливой молодёжи в сферу научных исследований и разработок. Что ваш вуз может предложить студентам в рамках научно-популярного трека?\n" +
                "В свою очередь Башкирский государственный университет принимает внутренние меры поддержки по привлечению и удержанию молодых исследователей в регионе. С 1 сентября в БашГУ будут реализованы несколько конкурсов.\n" +
                "Первый и наиболее значимый конкурс, который мы готовили не один год - поддержка молодежных исследовательских групп под руководством молодых ученых до 39 лет. Такой конкурс позволит не только создать инновационные продукты в вузе, но и сформирует определенное молодежное научное движение, научно-исследовательскую преемственность.\n" +
                "Вторым, не менее значимым элементом поддержки становится Конкурс «Трэвел-грантов» - субсидия, выделяемая студентам и аспирантам для участия в мероприятиях, проводимых на территории Российской Федерации, стран Содружества Независимых Государств (далее – СНГ) и за рубежом. Молодые исследователи смогут принимать участие в наиболее ярких значимых научных мероприятиях страны и мира, что, безусловно, даст положительный результат для региона.\n" +
                "\n" +
                "– Есть ли при вашем вузе какие-либо объекты научной инфраструктуры, где студенты могли бы проводить свои исследования? (И если да, то студенты каких направлений могли бы приезжать к вам в университет и проводить свои опыты?)\n" +
                "Каждая научная школа, кафедра и лаборатория позволяет студентам проводить научно-исследовательскую работу, так же для структуризации данных в университете функционирует проектный офис «Наука и инновации». Биологический факультет готов познакомить студентов с уникальными разработками вуза, показать достижения новых молодежной лаборатории. Физико-технический институт, в свою очередь, тесно взаимодействует с индустриальным сообществом региона и готов рассказать студентам о передовых разработках промышленности и производства.\n" +
                "\n" +
                "– Как вы считаете, как Программа молодежного и студенческого туризма влияет на развитие вузов и взаимодействие между вузами?\n" +
                "Студенческий туризм очень важен именно для формирования и становления молодого поколения. Такие путешествия влияют на новые формы межвузовского взаимодействия как научного, так и профориентационного, а студентам дают возможность знакомиться с новыми регионами и научными школами.\n" +
                "\n" +
                "– Как вы видите Программу Студтуризма в своем университете в следующем году? Что хотели бы добавить или реализовать?\n" +
                "Основываясь на опыте участия БашГУ прошлых лет, мы сделали вывод, что большая часть студентов заинтересовалась обучением в нашем вузе и рассматривает перспективу своего будущего в пределах Республики Башкортостан. Поэтому мы готовы предложить реализацию культурно-познавательного направления не только в период летних каникул, но и в зимний период.",
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsCardBinding.inflate(inflater, container, false)
        val id = requireArguments().getInt("id", 0)
        Glide.with(requireContext())
            .load(resources.getDrawable(images[id]))
            .into(binding.mainImage)
        binding.tagOne.text = tags[id][0]
        binding.tagTwo.text = tags[id][1]
        binding.tagThree.text = tags[id][2]
        binding.titleTextView.text = titles[id]
        binding.infoTextView.text = description[id]
        binding.toolBar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        return binding.root
    }

    companion object {
        fun newInstance(id: Int) : NewsMoreFragment {
            val fragment = NewsMoreFragment()
            val args = Bundle()
            args.putInt("id", id)
            fragment.arguments = args
            return fragment
        }
    }
}