package br.com.ldf.medium.addTwoNumbers;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Main {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbersHelper(l1, l2, 0);
    }

    private ListNode addTwoNumbersHelper(ListNode l1, ListNode l2, int carry) {
        // Caso base: se ambas as listas forem nulas e não houver carry, retorna null
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        // Pega os valores dos nós ou usa 0 se não houver nó
        int x = (l1 != null) ? l1.val : 0;
        int y = (l2 != null) ? l2.val : 0;

        // Calcula a soma atual e o novo carry
        int sum = x + y + carry;
        carry = sum / 10;

        // Cria o nó atual
        ListNode current = new ListNode(sum % 10);

        // Recursivamente calcula o próximo nó
        current.next = addTwoNumbersHelper(
                (l1 != null) ? l1.next : null,
                (l2 != null) ? l2.next : null,
                carry
        );

        return current;
    }
}