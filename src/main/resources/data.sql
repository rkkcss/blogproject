/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Dani
 * Created: 2021. júl. 1.
 */
insert into Blogger (id,name, email, password) values ( 1,'asd', 'galdani1997@gmail.com', '$2a$10$Z8XapFMAOA1PyJHenTasz.17A9G2/DlZ5EFmxjKKOnvKOJnEwQYxK');

insert into blogthemes(id, name) values (1,'Sztárok');
insert into blogthemes(id, name) values (2,'Blabla');

insert into post (id, content, title, blogger_id, themes_id) values (1,'ez a content 2', 'hahhahasidwion faszom', 1, 2);
insert into post (id, content, title, blogger_id, themes_id) values (2,'Ez most egy content', 'Elso blog bejegyzes', 1, 1);

insert into comments (id, email, name, comment, posted, post_id) values (1,'rkkcss@gmail.com', 'kis endre', 'megrakom a szádat', '2017-12-09', 2);
insert into comments (id, email, name, comment, posted, post_id) values (2,'galdani@gmail.com', 'danika endre', 'kommenteltem má megi', '2017-12-09', 1);

insert into messages (id, name, title, email, message) values (1,'danika endre', 'hallod', 'galdani@gmail.com', 'nagyon betyár itt minden én mondom neked báttya');
insert into messages (id, name, title, email, message) values (2,'danika endre', 'nemigaz', 'rkkcss@gmail.com', 'ez egy szar amit irtál én mondom neked báttya');
insert into messages (id, name, title, email, message) values (3,'micsoda jani', 'deigaz', 'mimimi@gmail.com', 'ez egy szar amit irtál én mondom neked báttya');
insert into messages (id, name, title, email, message) values (4,'kis ferenc', 'jajdejooo', 'jaja@gmail.com', 'ez is komoly meg minden de jo lenne valami uj en azt mondom neked kisfiam dorottya');
