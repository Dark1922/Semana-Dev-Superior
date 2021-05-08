import { Seller } from "./seller"

export type Sale = {
  id: number;
  visited: number;
  deals: number;
  amount: number;
  date: string;
  seller: Seller;
}

export type SalePage = {
  content?: Sale[]; //ele é do tipo lista/ array Sale dentro dele é uma lista de sale
  last: boolean;
  totalElements: number;
  totalPages: number;
  size?: number;
  first: boolean;
  number: number;
  numberOfElements?: number;
  empty?: boolean;
}

export type SaleSum = {
  sellerName: string, //tipo 
  sum: number, //tipo numerico
}

export type SaleSuccess = {
  sellerName: string;
  visited: number;
  deals: number;
}