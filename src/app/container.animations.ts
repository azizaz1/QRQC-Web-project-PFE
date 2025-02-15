import { trigger, state, style, animate, transition } from '@angular/animations';

export const containerAnimation = trigger('containerAnimation', [
  state('void', style({
    opacity: 0,
    transform: 'translateY(-20px)'
  })),
  transition('void => *', [
    animate('500ms ease-out')
  ]),
  transition('* => void', [
    animate('300ms ease-in')
  ])
]);
