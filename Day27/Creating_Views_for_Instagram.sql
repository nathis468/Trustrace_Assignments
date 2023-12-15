create database Day25_Instagram;

use Day25_Instagram;

create table users(
	user_id varchar(10) primary key,
	email varchar(20),
	verified bool,
	phnumber varchar(10),
	DOB varchar(20),
	pwd text
);

create table pages(
	page_id varchar(10) primary key,
	user_id varchar(10),
	page_name text,
	page_handle text,
	Bio text,
	DP text,
	Avatar text,
	pwd text,
	DOB varchar(20),
	page_privacy varchar(10),
	foreign key(user_id) references users(user_id)
);

create table followdetails(
	followers varchar(10),
	following varchar(10),
	foreign key(followers) references pages(page_id),
	foreign key(following) references pages(page_id)
);

create table chat(
	chat_id varchar(10) primary key,
	chat_type varchar(10),
	vanish_mode boolean,
	settings varchar(50)
);


create table message(
	message_id varchar(10) primary key,
	content varchar(200),
	sender varchar(10),
	Time time,
	chat_id varchar(10),
	isVanishMode boolean,
	foreign key(chat_id) references chat(chat_id),
	foreign key(sender) references pages(page_id)
);


create table chat_details(
	chat_id varchar(10),
	page_id varchar(10),
	isAdmin boolean,
	lastReadMessage_Id int,
	foreign key(chat_id) references chat(chat_id),
	foreign key(page_id) references pages(page_id)
);

create table device(
	device_id varchar(10) primary key,
	page_id varchar(10),
	device_location varchar(50),
	login_time time,
	logout_time time,
	cookie varchar(200),
	foreign key(page_id) references pages(page_id)
);


create table content(
	post_id varchar(10) primary key,
	page_id varchar(10),
	Post_Media varchar(20),
	Media_type varchar(20),
	Music_Id varchar(10),
	Views int8,
	Primary_Poster varchar(20),
	Likes int8,
	Caption text,
	Date_and_Time datetime,
	Location varchar(25),
	Music_Id_Timestamp timestamp,
	foreign key(page_id) references pages(page_id)
);


create table comments(
	comment_id varchar(10) primary key,
	post_id varchar(10),
	content varchar(100),
	parent_comment_id varchar(10),
	foreign key(post_id) references content(post_id),
	foreign key(parent_comment_id) references comments(comment_id)
);

create table collab_post(
	post_id varchar(10),
	page_id varchar(10),
	foreign key(post_id) references content(post_id),
	foreign key(page_id) references pages(page_id)
);

create table likes(
	page_id varchar(10),
	post_id varchar(10),
	comment_id varchar(10),
	foreign key(post_id) references content(post_id),
	foreign key(page_id) references pages(page_id),
	foreign key(comment_id) references comments(comment_id)
);

create table stories(
	story_id varchar(10) primary key,
	content_id varchar(10),
	liked_page_id varchar(10),
	foreign key(content_id) references content(post_id),
	foreign key(liked_page_id) references pages(page_id)
);

create table ref_stories(
	coordinates text, 
	story_id varchar(10),
	story_text text,
	foreign key(story_id) references stories(story_id)
);

create table music(
	music_id varchar(10) primary key,
	post_id varchar(10),
	title varchar(100),
	artist char(40),
	lyrics char(100),
	thumbnail char(100),
	foreign key(post_id) references content(post_id)
);

create table collection(
	collection_id varchar(10) primary key,
	collection_Name char(100),
	page_id varchar(10),
	foreign key(page_id) references pages(page_id)
);


create table collab(
	collab_id varchar(10) primary key,
	page_id varchar(10),
	is_Owner bool,
	foreign key(page_id) references pages(page_id)
);

create table saved(
	post_id varchar(10),
	collab_id varchar(10),
	collection_id varchar(10),
	foreign key(post_id) references content(post_id),
	foreign key(Collab_id) references collab(Collab_id),
	foreign key(collection_id) references collection(collection_id)
);


create table post(
	media_id varchar(10) primary key,
	post_id varchar(10),
	media_Link varchar(100),
	foreign key(post_id) references content(post_id)
);

create table tags(
	tag_id varchar(10) primary key,
	coords varchar(100),
	media_id  varchar(10),
	page_id  varchar(10),
	foreign key(page_id) references pages(page_id),
	foreign key(Media_id) references post(Media_id)
);


create table hashtags(
	post_id varchar(10) ,
	hashtag varchar(40),
	hashcount int,
	primary key(post_id,hashtag),
	foreign key(post_id) references post(post_id)
);



INSERT INTO users (user_id, email, verified, phnumber, DOB, pwd)
VALUES 
('user1', 'user1@example.com', true, '1234567890', '1990-01-01', 'password1'),
('user2', 'user2@example.com', false, '0987654321', '1985-05-15', 'password2'),
('user3', 'user3@example.com', true, '5555555555', '1999-12-25', 'password3'),
('user4', 'user4@example.com', true, '7777777777', '2000-03-10', 'password4'),
('user5', 'user5@example.com', false, '1111111111', '1988-08-20', 'password5');

INSERT INTO pages (page_id, user_id, page_name, page_handle, Bio, DP, Avatar, pwd, DOB, page_privacy)
VALUES 
('page1', 'user1', 'Page One', 'page_one', 'Bio for Page One', 'dp_url_one', 'avatar_url_one', 'page_pwd1', '1990-01-01', 'public'),
('page2', 'user2', 'Page Two', 'page_two', 'Bio for Page Two', 'dp_url_two', 'avatar_url_two', 'page_pwd2', '1985-05-15', 'private'),
('page3', 'user3', 'Page Three', 'page_three', 'Bio for Page Three', 'dp_url_three', 'avatar_url_three', 'page_pwd3', '1999-12-25', 'public'),
('page4', 'user4', 'Page Four', 'page_four', 'Bio for Page Four', 'dp_url_four', 'avatar_url_four', 'page_pwd4', '2000-03-10', 'public'),
('page5', 'user5', 'Page Five', 'page_five', 'Bio for Page Five', 'dp_url_five', 'avatar_url_five', 'page_pwd5', '1988-08-20', 'private');

INSERT INTO followdetails (followers, following)
VALUES 
('page1', 'page2'),
('page1', 'page3'),
('page2', 'page1'),
('page3', 'page1'),
('page3', 'page4');

INSERT INTO chat (chat_id, chat_type, vanish_mode, settings)
VALUES 
('chat1', 'private', false, 'setting1'),
('chat2', 'group', true, 'setting2'),
('chat3', 'private', false, 'setting3'),
('chat4', 'group', true, 'setting4'),
('chat5', 'private', false, 'setting5');

INSERT INTO message (message_id, content, sender, Time, chat_id, isVanishMode)
VALUES 
('message1', 'Hello!', 'page1', '10:00:00', 'chat1', false),
('message2', 'Hi there!', 'page2', '10:15:00', 'chat1', false),
('message3', 'Hey!', 'page1', '10:30:00', 'chat2', false),
('message4', 'What\'s up?', 'page3', '10:45:00', 'chat2', false),
('message5', 'Good morning!', 'page2', '11:00:00', 'chat3', false);


INSERT INTO content (post_id, page_id, Post_Media, Media_type, Music_Id, Views, Primary_Poster, Likes, Caption, Date_and_Time, Location, Music_Id_Timestamp)
VALUES 
('post1','page1','story','video','music id 1',1000,'primary poster 1',1000,'first caption','2000-01-01 01:01:01','location 1','2022-05-08 14:30:45'),
('post2','page2','story','photo','music id 2',2000,'primary poster 2',2000,'second caption','2000-02-02 02:02:02','location 2','2022-05-08 14:30:45'),
('post3','page3','post','video','music id 3',3000,'primary poster 3',3000,'third caption','2000-03-03 03:03:03','location 3','2022-05-08 14:30:45'),
('post4','page4','story','photo','music id 4',4000,'primary poster 4',4000,'fourth caption','2000-04-04 04:04:04','location 4','2022-05-08 14:30:45'),
('post5','page5','post','video','music id 5',5000,'primary poster 5',5000,'fifth caption','2000-05-05 05:05:05','location 5','2022-05-08 14:30:45');


INSERT INTO post(media_id, post_id, media_Link)
VALUES
('media 1', 'post1', 'media  link 1'),
('media 2', 'post2', 'media  link 2'),
('media 3', 'post3', 'media  link 3'),
('media 4', 'post4', 'media  link 4');

INSERT INTO  hashtags(post_id, hashtag,	hashcount)
VALUES
('post1', 'hashtag1', 1000),
('post2', 'hashtag2', 2000),
('post3', 'hashtag3', 3000),
('post4', 'hashtag4', 4000);


create view post_recomendation as(select post_id, likes from content order by likes desc);
create view reals_recomendation as(select post_id, likes ,media_type from content where media_type='video' order by likes desc);
create view device_history as(select device_id, p.page_id,device_location,login_time from device d inner join pages p on d.page_id=p.page_id);
create view storie_details as(select followers,following,post_id from followdetails inner join content on following=page_id where post_media='story');
create view search as (select page_handle,page_name,location,hashtag from pages,content,hashtags where content.post_id='post1');