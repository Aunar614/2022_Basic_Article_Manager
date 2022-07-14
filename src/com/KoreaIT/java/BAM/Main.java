package com.KoreaIT.java.BAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("==프로그램 시작==");

		Scanner sc = new Scanner(System.in);

		int articleNum = 0;

		List<Article> articles = new ArrayList<>();

		while (true) {

			System.out.printf("명령어 )");
			String cmd = sc.nextLine().trim();

			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해주세요");
				continue;
			}

			if (cmd.equals("exit")) {
				break;
			}

			if (cmd.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("게시물이 없습니다.");
					continue;
				}
				System.out.println("번호   :    제목");
				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);

					System.out.printf(" %d    :    %s\n", article.id, article.title);
				}

			} else if (cmd.equals("article write")) {
				int id = articleNum + 1;
				articleNum = id;
				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();

				articles.add(new Article(id, title, body));

				System.out.printf("%d 번 글이 생성되었습니다.\n", id);

			} else if (cmd.startsWith("article detail ")) {
				
				String[] cmdBits = cmd.split(" ");
				int id = Integer.parseInt(cmdBits[2]);
				
				
			} 
			else if (cmd.startsWith("article delete 1")) {
				if (articles.size() == 0) {
					System.out.println("1번 게시물은 존재하지 않습니다");
				} else {
					articles.remove(0);
					System.out.println("1번 게시물이 삭제되었습니다");
				}
			} else {
				System.out.println("존재하지 않는 명령어 입니다.");
			}

		}

		System.out.println("==프로그램 끝==");
		sc.close();
	}
}

class Article {
	int id;
	String title;
	String body;

	Article(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}
}
