export interface News {
  author: string;
  title: string;
  description: string;
  date: string;
  sourceName: string;
  articleUrl: string;
  imageUrl: string;
}

export interface NewsContainer {

  country: string,
  category: string,
  articles: News[],
}


