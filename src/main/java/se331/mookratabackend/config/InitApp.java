package se331.mookratabackend.config;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se331.mookratabackend.entity.News;
import se331.mookratabackend.entity.Comment;
import se331.mookratabackend.repository.CommentRepository;
import se331.mookratabackend.repository.NewsRepository;
import se331.mookratabackend.security.user.Role;
import se331.mookratabackend.security.user.User;
import se331.mookratabackend.security.user.UserRepository;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    final NewsRepository newsRepository;
    final CommentRepository commentRepository;
    final UserRepository userRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent event) {
        News news1, news2, news3, news4, news5, news6, news7, news8, news9, news10;
        News news11, news12, news13, news14, news15, news16, news17, news18, news19, news20;
        Comment comment1, comment2, comment3, comment4, comment5, comment6, comment7, comment8, comment9;
        Comment comment10, comment11, comment12, comment13, comment14;

        addUser();

        news1 = newsRepository.save(News.builder()
                .topic("Scientists Discover Life on Mars")
                .shortDetail("Scientist makes stunning confession as he claims life already found on Mars.")
                .fullDetail("Dr Gilbert Levin, who worked on the Viking Mars landers in the 1970s, claims NASA had already answered the \"ultimate question\", that is, that Mars supports alien life. Writing in a blog post for American Scientific, Dr Levin said the rover he worked on found biological formations that revealed the presence of microbial organisms. According to him, the experiments conducted on the Martian soil produced results very similar to those expected if living microorganisms were present. While NASA never officially confirmed his interpretation, Levin argues that the data should not be dismissed and that it strongly indicates biological activity on the Red Planet. He has urged the scientific community to revisit these findings with modern technology and consider the possibility that Mars has hosted or may still host microbial life.")
                .reporter("Joel Day")
                .reportDate("2019-08-16T10:00:00")
                .imageUrl("https://i.ibb.co/hJX1B5rJ/TNA70-Zubrin-Brenner-Spacek-banner.jpg")
                .build());

        news2 = newsRepository.save(News.builder()
                .topic("New Tech Can Charge Phones in 10 Seconds")
                .shortDetail("Startup claims to have invented ultra-fast phone charger.")
                .fullDetail("A small tech startup has announced a charger that can fully charge a smartphone in just 10 seconds. Scientists are divided, some calling it a breakthrough while others demand proof of its safety and battery longevity. The company behind the technology claims it uses a combination of graphene-based conductors and a new type of supercapacitor, which allows energy to be transferred at extremely high speeds without damaging the battery. Demonstrations have reportedly shown promising results, with phones reaching 100% charge in less than 15 seconds under controlled conditions. However, critics warn that the long-term health of the batteries remains unknown, and consumer safety testing will be crucial before mass adoption. If proven safe, this innovation could completely change how we use portable electronics, removing one of the biggest inconveniences of modern smartphones.")
                .reporter("David Chen")
                .reportDate("2025-08-17T09:15:00")
                .imageUrl("https://i.ibb.co/Gf60QcdW/7aff17ecdb3bd99d058ef89c5c0aca2b.webp")
                .build());

        // Comments for news2
        comment1 = commentRepository.save(Comment.builder()
                .user(user2)
                .vote("Real")
                .comment("I've seen their demo at CES with my own eyes, and it's absolutely real technology. They plugged in a phone that was at 5% battery and within seconds it jumped to 100%. The audience was shocked. Of course, we still need to see how it performs outside controlled conditions, but the proof of concept is there.")
                .imageUrls(Arrays.asList(
                        "https://i.postimg.cc/cL5rRsnR/News02-Image.webp",
                        "https://i.ibb.co/YFWD1YnP/257477-Swippitt-CES-2025-AJohnson-0008.webp",
                        "https://i.ibb.co/wrsbM9Cb/257477-Swippitt-CES-2025-AJohnson-0007.webp",
                        "https://i.ibb.co/QFPMhqxz/22892.jpg"
                ))
                .news(news2)
                .build());

        comment2 = commentRepository.save(Comment.builder()
                .user(user7)
                .vote("Fake")
                .comment("This seems way too good to be true, and I'm very skeptical. Technology companies sometimes exaggerate what they can do just to gain publicity and funding. Until I can buy this charger and test it myself, I will consider this more of a marketing stunt than a real breakthrough.")
                .imageUrls(List.of())
                .news(news2)
                .build());

        comment3 = commentRepository.save(Comment.builder()
                .user(user4)
                .vote("Real")
                .comment("They explained the battery chemistry during their presentation, and it actually makes sense. The use of graphene conductors and supercapacitors is something scientists have been exploring for years. If they've solved the safety and stability issues, this could be a massive game-changer for the electronics industry.")
                .imageUrls(List.of())
                .news(news2)
                .build());

        comment4 = commentRepository.save(Comment.builder()
                .user(user3)
                .vote("Real")
                .comment("I was lucky enough to actually try using the device at the exhibition, and it worked exactly as advertised. My phone charged from nearly dead to full in under 15 seconds. It felt surreal to witness, but I can confirm that at least in that setting, it really works perfectly.")
                .imageUrls(List.of("https://i.postimg.cc/4x3YHKm4/News02-Comment02.webp"))
                .news(news2)
                .build());

        comment5 = commentRepository.save(Comment.builder()
                .user(user3)
                .vote("Fake")
                .comment("I'm skeptical about this whole idea because charging a battery that fast has to come with serious downsides. Even if it works in the short term, I worry that the battery will degrade much faster after multiple charges. Long-term testing needs to be done before people can trust this technology.")
                .imageUrls(List.of())
                .news(news2)
                .build());

        comment6 = commentRepository.save(Comment.builder()
                .user(user10)
                .vote("Real")
                .comment("I have seen multiple independent reviewers post videos about this charger on YouTube, and most of them show that the device actually works as described. Of course, prototypes can be impressive, but it does seem legit based on the feedback. If it passes safety tests, this could be revolutionary.")
                .imageUrls(List.of())
                .news(news2)
                .build());

        comment7 = commentRepository.save(Comment.builder()
                .user(user9)
                .vote("Real")
                .comment("Graphene-based technology is widely recognized as the future of high-speed charging and energy storage. Many research labs have been working on this concept, so it's not surprising that someone finally made a working prototype. It might take time before it's affordable, but I believe this technology is real.")
                .imageUrls(List.of())
                .news(news2)
                .build());

        comment8 = commentRepository.save(Comment.builder()
                .user(user6)
                .vote("Fake")
                .comment("Until I can actually buy one of these chargers in a store and use it with my own phone, I don't believe it. Demonstrations can be staged or carefully controlled. Mass production and consumer use are completely different challenges than showing off a single working prototype.")
                .imageUrls(List.of())
                .news(news2)
                .build());

        comment9 = commentRepository.save(Comment.builder()
                .user(user11)
                .vote("Real")
                .comment("Supercapacitors are already proven to work in other industries, so it's not far-fetched that they could be adapted for phones. The biggest hurdle has always been making them safe and efficient for small-scale devices. If this company has cracked the problem, then this is a realistic innovation.")
                .imageUrls(List.of())
                .news(news2)
                .build());

        comment10 = commentRepository.save(Comment.builder()
                .user(user2)
                .vote("Fake")
                .comment("Charging a phone in 10 seconds sounds impressive, but the question is how many times you can do that before the battery starts to degrade. Batteries are delicate, and charging them so fast could create long-term issues. I'm not convinced this is something consumers can rely on yet.")
                .imageUrls(List.of())
                .news(news2)
                .build());

        comment11 = commentRepository.save(Comment.builder()
                .user(user8)
                .vote("Real")
                .comment("This kind of innovation could completely change how we use smartphones and other devices. Imagine never having to wait hours for your battery to recharge. If it can be made safe and affordable, this could be one of the biggest technological breakthroughs of the decade.")
                .imageUrls(List.of())
                .news(news2)
                .build());

        comment12 = commentRepository.save(Comment.builder()
                .user(user3)
                .vote("Fake")
                .comment("Even Tesla, with all its advanced technology, doesn't have a battery that can charge fully in seconds. If this startup really achieved something that big, it would mean they're ahead of the world's biggest tech companies. I find that very hard to believe without more evidence.")
                .imageUrls(List.of())
                .news(news2)
                .build());

        comment13 = commentRepository.save(Comment.builder()
                .user(user4)
                .vote("Real")
                .comment("CES demos are usually pretty reliable because companies know they'll be under heavy scrutiny from the press and experts. I think the technology is real, but whether it can be scaled up for everyday use is the bigger question. Still, this feels like an exciting step forward.")
                .imageUrls(List.of())
                .news(news2)
                .build());

        comment14 = commentRepository.save(Comment.builder()
                .user(user2)
                .vote("Fake")
                .comment("This could just be a flashy prototype designed to get investors excited. Many times in tech history we've seen amazing demos that never reached the consumer market. Until it survives safety testing and mass production, I will remain doubtful about its real-world potential.")
                .imageUrls(List.of())
                .news(news2)
                .build());

        news3 = newsRepository.save(News.builder()
                .topic("Trump to Host Putin and Zelenskyy for Trilateral Summit")
                .shortDetail("U.S. President Donald Trump plans a summit with Russian President Vladimir Putin and Ukrainian President Volodymyr Zelenskyy.")
                .fullDetail("President Trump is reportedly organizing a trilateral summit with Presidents Putin and Zelenskyy to discuss a broader peace settlement amid ongoing tensions in Ukraine. The meeting, which is expected to take place later this month, would mark the first time the three leaders have come together to directly negotiate solutions. According to officials, the agenda will likely include discussions on a ceasefire, prisoner exchanges, energy cooperation, and the possibility of international peacekeeping forces in disputed areas. Analysts suggest this could be a major turning point in the conflict, though skepticism remains about whether the talks will produce tangible results. Both Russia and Ukraine have expressed cautious optimism, while international observers stress the importance of a transparent and verifiable process.")
                .reporter("David Chen")
                .reportDate("2025-08-14T09:15:00")
                .imageUrl("https://i.ibb.co/Kc5MDGXZ/1536x864-cmsv2-da46b6f8-03fe-5013-8ce2-1d55ceea93c9-8120620.webp")
                .build());

        commentRepository.save(Comment.builder()
                .user(user8)
                .vote("Real")
                .comment("Trump did announce this. It's real.")
                .imageUrls(List.of())
                .news(news3)
                .build());

        news4 = newsRepository.save(News.builder()
                .topic("Global Warming Reversed Overnight")
                .shortDetail("Environmentalists report a sudden global temperature drop.")
                .fullDetail("Environmental groups are celebrating an unexpected global temperature decrease, attributing it to a sudden shift in ocean currents and atmospheric conditions. Reports claim that average global surface temperatures dropped by nearly 1.5°C within a single week, a phenomenon never before recorded in modern climate history. Scientists are scrambling to study the cause, with early theories suggesting a combination of volcanic activity, changes in solar radiation, and rare ocean current reversals could be responsible. However, many experts remain skeptical, warning that such drastic changes are unlikely to be permanent. Climate activists argue that while the phenomenon might be temporary, it demonstrates how sensitive Earth's climate is to sudden natural or artificial shifts, raising new debates about geoengineering and climate intervention strategies.")
                .reporter("Brian Scott")
                .reportDate("2025-08-15T09:30:00")
                .imageUrl("https://i.ibb.co/YBT6vryb/1629909383-imgkeepingcool.jpg")
                .build());

        commentRepository.save(Comment.builder()
                .user(user7)
                .vote("Fake")
                .comment("This is clearly made up. No scientific evidence.")
                .imageUrls(List.of())
                .news(news4)
                .build());

        news5 = newsRepository.save(News.builder()
                .topic("China's Foreign Minister Wang Yi to Visit India for Border Talks")
                .shortDetail("Chinese Foreign Minister Wang Yi is scheduled to visit India for border discussions.")
                .fullDetail("Chinese Foreign Minister Wang Yi is scheduled to visit India on Monday for discussions regarding the ongoing boundary issue between the two countries. The visit comes amid heightened tensions along the Line of Actual Control (LAC), where recent skirmishes have reignited concerns of instability. Officials from both nations confirmed that talks will focus on de-escalation measures, strengthening communication channels, and exploring long-term solutions to prevent future conflicts. Analysts suggest that Wang Yi's visit represents an important diplomatic step, signaling China's willingness to negotiate despite growing political and military rivalries. Both sides are also expected to discuss trade relations, regional security, and their roles in broader Asian geopolitics.")
                .reporter("David Chen")
                .reportDate("2025-08-16T11:30:00")
                .imageUrl("https://i.postimg.cc/wTqvnt55/News05.webp")
                .build());

        commentRepository.save(Comment.builder()
                .user(user5)
                .vote("Real")
                .comment("Reported by Times of India, definitely real.")
                .imageUrls(List.of())
                .news(news5)
                .build());

        news6 = newsRepository.save(News.builder()
                .topic("World Governments Agree to One-World Currency")
                .shortDetail("Nations announce a single global currency.")
                .fullDetail("Leaders from over 100 countries have agreed to adopt a single global currency, aiming to streamline international trade and reduce economic disparities. The proposal, described as one of the boldest economic experiments in modern history, seeks to eliminate exchange rate fluctuations and provide a uniform standard for global commerce. Advocates argue that it could make international transactions cheaper, reduce corruption, and stabilize weaker economies. Critics, however, warn that it could undermine national sovereignty, create economic dependencies, and concentrate financial power in the hands of a few global institutions. The details of the rollout, including how existing currencies will be converted, remain unclear, and experts caution that such a sweeping change will face enormous political, logistical, and public trust challenges.")
                .reporter("Diana Lopez")
                .reportDate("2025-08-16T11:00:00")
                .imageUrl("https://i.ibb.co/fVB96xnc/shutterstock-218069710.jpg")
                .build());

        commentRepository.save(Comment.builder()
                .user(user10)
                .vote("Fake")
                .comment("This is clearly fake news. No official announcements.")
                .imageUrls(List.of())
                .news(news6)
                .build());

        news7 = newsRepository.save(News.builder()
                .topic("Zelenskyy to Meet Trump in Washington")
                .shortDetail("Ukrainian President Volodymyr Zelenskyy is set to meet U.S. President Donald Trump in Washington.")
                .fullDetail("Following a summit in Alaska between Trump and Putin, President Zelenskyy is scheduled to meet President Trump in Washington to discuss Ukraine's security and sovereignty. The meeting comes at a critical time, as Ukraine continues to face territorial disputes and heightened pressure from Russia. U.S. officials have indicated that the agenda will include military aid packages, NATO cooperation, and strategies to strengthen Ukraine's independence in the face of foreign influence. Observers note that this will be Zelenskyy's first official visit to Washington since the escalation of tensions, making it a symbolic moment in U.S.-Ukraine relations. Analysts believe the outcome of the talks could have far-reaching implications for regional stability and U.S. foreign policy in Eastern Europe.")
                .reporter("Emily Johnson")
                .reportDate("2025-08-15T12:00:00")
                .imageUrl("https://i.postimg.cc/xTnJYpQz/News07.jpg")
                .build());

        commentRepository.save(Comment.builder()
                .user(user7)
                .vote("Real")
                .comment("Confirmed by multiple news sources.")
                .imageUrls(List.of())
                .news(news7)
                .build());

        news8 = newsRepository.save(News.builder()
                .topic("Thompson Beats Lyles in Olympic Final Rematch")
                .shortDetail("Jamaican sprinter Kishane Thompson defeats Noah Lyles in a 100m race.")
                .fullDetail("At the Silesia Diamond League meeting, Jamaican sprinter Kishane Thompson triumphed over Olympic champion Noah Lyles in a thrilling 100m rematch, clocking 9.87 seconds to Lyles' season-best 9.90. The race, heavily anticipated by athletics fans worldwide, showcased Thompson's explosive acceleration and finishing speed, establishing him as one of the top sprinters heading into future international competitions. Lyles, despite the narrow loss, praised Thompson's performance and vowed to come back stronger in upcoming events. Commentators hailed the race as one of the most exciting head-to-head showdowns of the season, signaling a new rivalry that could dominate men's sprinting for years to come.")
                .reporter("Jason Miller")
                .reportDate("2025-08-16T14:30:00")
                .imageUrl("https://i.postimg.cc/XvGXxTfT/News08.jpg")
                .build());

        commentRepository.save(Comment.builder()
                .user(user5)
                .vote("Real")
                .comment("I watched the race, Thompson really won.")
                .imageUrls(List.of())
                .news(news8)
                .build());

        news9 = newsRepository.save(News.builder()
                .topic("Humanoid Robot Games in Beijing")
                .shortDetail("Robots compete in sports and performance events in Beijing.")
                .fullDetail("In a quirky debut of what organizers called the 'World's First Humanoid Robot Games,' over 500 robots competed in soccer, boxing, running, and even dance. Held in Beijing, the event highlighted the humorous side of robotics: while some robots clumsily tumbled on the field, others struggled to play simple instruments. Despite the awkwardness, the spectacle served as a lighthearted showcase of current AI development and how far robots still have to go to achieve human-level mobility and coordination.")
                .reporter("Liang Zhao")
                .reportDate("2025-08-12T10:00:00")
                .imageUrl("https://i.postimg.cc/D0ZXxQ9p/9.webp")
                .build());

        commentRepository.save(Comment.builder()
                .user(user8)
                .vote("Real")
                .comment("Looks like the bots are having more fun crashing than competing.")
                .imageUrls(List.of())
                .news(news9)
                .build());

        news10 = newsRepository.save(News.builder()
                .topic("Samsung Unveils World's First Micro-RGB TV")
                .shortDetail("Samsung introduces new display breakthrough.")
                .fullDetail("Samsung is set to debut the world's first Micro RGB TV at the upcoming IFA show in Germany. This breakthrough television uses micro-scale RGB LEDs arranged behind the screen, enabling super-fine color control unmatched by conventional mini-LED technology. The result promises sharper contrast, more vivid colors, and improved energy efficiency—potentially revolutionizing how high-end displays perform.")
                .reporter("John Archer")
                .reportDate("2025-08-13T11:00:00")
                .imageUrl("https://i.postimg.cc/jj0yR7fC/10.jpg")
                .build());

        commentRepository.save(Comment.builder()
                .user(user10)
                .vote("Real")
                .comment("Samsung never stops pushing display tech forward—can't wait to see it live.")
                .imageUrls(List.of())
                .news(news10)
                .build());

        news11 = newsRepository.save(News.builder()
                .topic("OpenAI Releases GPT-5 with 'PhD-Level Intelligence'")
                .shortDetail("AI model pushes reasoning and creativity further.")
                .fullDetail("OpenAI has officially launched GPT-5, a major upgrade to the ChatGPT model boasting so-called 'PhD-level intelligence.' The model showcases vastly improved reasoning, creativity, and contextual understanding. While still not perfect, testers report it can write essays, solve complex problems, and even debate with nuanced arguments—raising both excitement and concerns about AI's role in education, research, and ethics.")
                .reporter("Emily Johnson")
                .reportDate("2025-08-10T09:00:00")
                .imageUrl("https://i.ibb.co/Pvm36037/1754617615393.png")
                .build());

        commentRepository.save(Comment.builder()
                .user(user4)
                .vote("Real")
                .comment("GPT-5 thinks faster than I do—I'm both amazed and intimidated.")
                .imageUrls(List.of())
                .news(news11)
                .build());

        news12 = newsRepository.save(News.builder()
                .topic("NASA Finds Evidence of Planet around Alpha Centauri A")
                .shortDetail("Gas giant candidate spotted near Earth's closest star system.")
                .fullDetail("NASA's latest observations have delivered the most compelling evidence yet for a gas giant orbiting Alpha Centauri A, one of our nearest stellar neighbors. Using precise spectral data and orbital modeling, scientists have identified telltale signs of a massive companion influencing the star's motion. If confirmed, this discovery could reshape our understanding of planetary systems nearby and spark renewed interest in interstellar exploration.")
                .reporter("Brian Scott")
                .reportDate("2025-08-11T12:30:00")
                .imageUrl("https://i.postimg.cc/dVT8MBLz/12.jpg")
                .build());

        commentRepository.save(Comment.builder()
                .user(user6)
                .vote("Real")
                .comment("Imagine if there's a Jupiter cousin nearby—wow.")
                .imageUrls(List.of())
                .news(news12)
                .build());

        news13 = newsRepository.save(News.builder()
                .topic("Sunlight-Activated Material Breaks Down 'Forever Chemicals'")
                .shortDetail("Australian scientists develop breakthrough cleanup tech.")
                .fullDetail("Researchers at the University of Adelaide have developed a novel sunlight-activated material that effectively breaks down PFAS—so-called 'forever chemicals' notoriously resistant to degradation—into harmless fluoride and other benign byproducts. This eco-friendly method could be scaled for cleanup of contaminated water sources, offering a real-world tool for tackling one of environmental science's most persistent challenges.")
                .reporter("Diana Lopez")
                .reportDate("2025-08-09T14:00:00")
                .imageUrl("https://i.postimg.cc/qRpn3HjT/13.jpg")
                .build());

        commentRepository.save(Comment.builder()
                .user(user7)
                .vote("Real")
                .comment("Finally, something that can help clean up PFAS pollution—huge win.")
                .imageUrls(List.of())
                .news(news13)
                .build());

        news14 = newsRepository.save(News.builder()
                .topic("Rising Sea Levels Threaten Easter Island's Moai")
                .shortDetail("Study warns cultural heritage at risk by 2080.")
                .fullDetail("A new study projects that growing sea levels could endanger the iconic moai statues of Easter Island by 2080. As coastal exposure increases due to climate change, these culturally and historically significant monuments face risks from erosion, saltwater corrosion, and land loss—raising alarms for preservationists and indigenous communities alike.")
                .reporter("Jason Miller")
                .reportDate("2025-08-08T13:00:00")
                .imageUrl("https://i.ibb.co/1fpdMPFt/image-1.jpg")
                .build());

        commentRepository.save(Comment.builder()
                .user(user11)
                .vote("Real")
                .comment("These statues hold so much cultural heritage—it'd be tragic to lose them.")
                .imageUrls(List.of())
                .news(news14)
                .build());

        news15 = newsRepository.save(News.builder()
                .topic("New Carbon Allotrope Created: cyclo[48]carbon")
                .shortDetail("Oxford chemists synthesize unique carbon ring.")
                .fullDetail("Chemists at Oxford University have synthesized cyclo[48]carbon—an entirely new carbon allotrope comprised of 48 carbon atoms linked in alternating single and triple bonds, forming a ring structure. This molecular marvel exhibits unique electronic and structural properties, offering insights into carbon chemistry and potential applications in nanotechnology.")
                .reporter("David Chen")
                .reportDate("2025-08-07T16:00:00")
                .imageUrl("https://i.ibb.co/5gKYBtYb/origin.jpg")
                .build());

        commentRepository.save(Comment.builder()
                .user(user2)
                .vote("Real")
                .comment("Carbon keeps surprising us—can't wait to see how this opens new materials.")
                .imageUrls(List.of())
                .news(news15)
                .build());

        news16 = newsRepository.save(News.builder()
                .topic("Flash Flood in Inner Mongolia Claims Lives")
                .shortDetail("Disaster kills 10 at campsite in Urad Rear Banner.")
                .fullDetail("A sudden flash flood swept through a campsite in Urad Rear Banner, Inner Mongolia, killing ten people and leaving two missing. The disaster underscores intensifying extreme weather events in the region, prompting calls for improved early warning systems, infrastructure resilience, and emergency preparedness.")
                .reporter("Brian Scott")
                .reportDate("2025-08-06T18:00:00")
                .imageUrl("https://i.ibb.co/gLtVNm5g/texas-flood-7-gty-gmh-250707-1751891608305-hp-Main-16x9.jpg")
                .build());

        commentRepository.save(Comment.builder()
                .user(user4)
                .vote("Real")
                .comment("Terrible news—another reminder we must take climate threats seriously.")
                .imageUrls(List.of())
                .news(news16)
                .build());

        news17 = newsRepository.save(News.builder()
                .topic("France's Nuclear Plant Shut by Jellyfish Swarm")
                .shortDetail("Jellyfish clog cooling system at Gravelines station.")
                .fullDetail("A jellyfish swarm has caused the shutdown of the Gravelines Nuclear Power Station in France by clogging its cooling system. The rare event disrupted reactor operations and highlighted the vulnerability of critical infrastructure to nature's unpredictability, especially as ocean ecosystems and marine behavior change.")
                .reporter("Emily Johnson")
                .reportDate("2025-08-05T17:30:00")
                .imageUrl("https://i.ibb.co/2Ydj53JY/4544.webp")
                .build());

        commentRepository.save(Comment.builder()
                .user(user10)
                .vote("Real")
                .comment("Of all things, jellyfish—nature always finds a way to surprise.")
                .imageUrls(List.of())
                .news(news17)
                .build());

        news18 = newsRepository.save(News.builder()
                .topic("Pauline Ferrand-Prévot Wins Tour de France Femmes")
                .shortDetail("First French cyclist since 1989 wins Tour event.")
                .fullDetail("Pauline Ferrand-Prévot made history by becoming the first French cyclist since 1989 to win any Tour de France category, triumphing in the women's competition. Her victory—a blend of endurance and tactical brilliance—has invigorated French cycling and inspired renewed interest in women's racing.")
                .reporter("Jason Miller")
                .reportDate("2025-08-04T12:00:00")
                .imageUrl("https://i.ibb.co/cc3K4Dmj/gettyimages-2228351915.jpg")
                .build());

        commentRepository.save(Comment.builder()
                .user(user9)
                .vote("Real")
                .comment("Amazing performance—finally seeing French women shine in cycling again!")
                .imageUrls(List.of())
                .news(news18)
                .build());

        news19 = newsRepository.save(News.builder()
                .topic("Major Anti-Immigration Protests Sweep UK Cities")
                .shortDetail("Clashes reported in multiple towns and London.")
                .fullDetail("Between August 8–10, anti-immigration protests spread across various UK cities. In Epping, Norwich, Canary Wharf, and Hoylake, demonstrators and counter-protesters clashed, leading to several arrests and isolated assaults. While mostly contained by police, the protests exposed deep divisions over immigration policy and public discourse.")
                .reporter("Diana Lopez")
                .reportDate("2025-08-10T15:00:00")
                .imageUrl("https://i.ibb.co/FL4dG8gy/U57-EEDEDRRIDRPYFI7-DNX7-DSKY.jpg")
                .build());

        commentRepository.save(Comment.builder()
                .user(user3)
                .vote("Real")
                .comment("Tensions are flaring over immigration—hope dialogue returns soon.")
                .imageUrls(List.of())
                .news(news19)
                .build());

        news20 = newsRepository.save(News.builder()
                .topic("Kaiwa Unveils Humanoid Robot Pregnancy System")
                .shortDetail("Chinese company presents artificial womb tech.")
                .fullDetail("At the 2025 World Robot Conference in Beijing, Kaiwa Technology shocked the world by presenting a humanoid robot pregnancy system with an artificial womb—with prototypes expected in 2026 at a price of ~$14,000. Aimed at offering alternatives for infertility and reproductive medicine, the innovation raises profound ethical, legal, and societal questions about artificial gestation.")
                .reporter("David Chen")
                .reportDate("2025-08-12T09:45:00")
                .imageUrl("https://i.ibb.co/RF6vtbQ/IE-photo-ratio-19201080-2.webp").build());
    }

    User user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11, user12;
    private void addUser() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        user1 = User.builder()
                .password(encoder.encode("admin"))
                .firstname("Admin")
                .lastname("User")
                .email("admin@admin.com")
                .build();
        user1.getRoles().add(Role.ROLE_ADMIN);
        userRepository.save(user1);

        user2 = User.builder()
                .password(encoder.encode("test"))
                .firstname("Test")
                .lastname("User")
                .email("test@gmail.com")
                .build();
        user2.getRoles().add(Role.ROLE_MEMBER);
        userRepository.save(user2);

        user3 = User.builder()
                .password(encoder.encode("password"))
                .firstname("Mike")
                .lastname("Lee")
                .email("mike.lee@example.com")
                .build();
        user3.getRoles().add(Role.ROLE_MEMBER);
        userRepository.save(user3);

        user4 = User.builder()
                .password(encoder.encode("password"))
                .firstname("Anna")
                .lastname("Patel")
                .email("anna.patel@example.com")
                .build();
        user4.getRoles().add(Role.ROLE_MEMBER);
        userRepository.save(user4);

        user5 = User.builder()
                .password(encoder.encode("password"))
                .firstname("Lucas")
                .lastname("Smith")
                .email("lucas.smith@example.com")
                .build();
        user5.getRoles().add(Role.ROLE_MEMBER);
        userRepository.save(user5);

        user6 = User.builder()
                .password(encoder.encode("password"))
                .firstname("Olivia")
                .lastname("Green")
                .email("olivia.green@example.com")
                .build();
        user6.getRoles().add(Role.ROLE_MEMBER);
        userRepository.save(user6);

        user7 = User.builder()
                .password(encoder.encode("password"))
                .firstname("James")
                .lastname("Wong")
                .email("james.wong@example.com")
                .build();
        user7.getRoles().add(Role.ROLE_MEMBER);
        userRepository.save(user7);

        user8 = User.builder()
                .password(encoder.encode("password"))
                .firstname("Sophia")
                .lastname("Lee")
                .email("sophia.lee@example.com")
                .build();
        user8.getRoles().add(Role.ROLE_MEMBER);
        userRepository.save(user8);

        user9 = User.builder()
                .password(encoder.encode("password"))
                .firstname("Daniel")
                .lastname("Evans")
                .email("daniel.evans@example.com")
                .build();
        user9.getRoles().add(Role.ROLE_MEMBER);
        userRepository.save(user9);

        user10 = User.builder()
                .password(encoder.encode("password"))
                .firstname("Maria")
                .lastname("Gonzalez")
                .email("maria.gonzalez@example.com")
                .build();
        user10.getRoles().add(Role.ROLE_MEMBER);
        userRepository.save(user10);

        user11 = User.builder()
                .password(encoder.encode("password"))
                .firstname("Tommy")
                .lastname("Nguyen")
                .email("tommy.nguyen@example.com")
                .build();
        user11.getRoles().add(Role.ROLE_MEMBER);
        userRepository.save(user11);

        user12 = User.builder()
                .password(encoder.encode("password"))
                .firstname("Emma")
                .lastname("Wilson")
                .email("emma.wilson@example.com")
                .build();
        user12.getRoles().add(Role.ROLE_MEMBER);
        userRepository.save(user12);
    }

}