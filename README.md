# CSC-420-Assignment-4
This homework builds on HW3 by adding drag-and-drop and copy/paste functionality.

Keep the functionality of HW3 (pre-load all images, have a progress bar). In addition, once the main interface shows up, you need to have three components on it: a list of country names, a text box below the list, and a panel to display a flag to the right of those. The interaction between them is the following:
The list has no bearing on anything else. It serves to display the possible country names, and as a source of drag-and-drop / copy motions. Use a JList for this (no combo boxes, checkboxes, or anything else). Make sure your list displays at the right size for your layout, and that the user can only select one item at a time for drag or copy purposes.
The text box serves as the destination of drag-and-drop / paste motions. Users can also manually type text in the text box.
The panel to display images is updated whenever text is entered in the text box. If the text is a country name that is recognized, the flag of the respective country is shown.
I will test your application by dropping a country name selected from the list; by typing one in the box myself; and also by dropping / pasting text selected outside of your application (e.g., in a separate text editor). Make sure all of these combinations work.

Ensure that you are using good UI design principles when placing your components, as usual. I want your interface to look good.

Hints: since there are no buttons, you'll have to be careful to update the flag when something interesting is entered / dropped / pasted in the text box. Look at everything the drag-and-drop framework provides for you, as well as focus listeners and keyboard listeners. Here is a link to Swing's drag-and-drop trail.

Make sure your code looks good. I don't want to see a single class responsible for everything this time. If you have more than three lines of code in a method, don't use an anonymous class; make a named one instead. Also, every class should be either public, or an inner / anonymous one. I will ask you why you made certain design decisions, and will drop points if you can't explain yourself. This means you may have to refactor your HW3 code before you start HW4.

Submit your sources and resources (all your .java files in the correct directory structure, as well as the images you use in the proper place within the directory structure) to the Blackboard dropbox before the deadline.

I'll want you to demonstrate how your homework works after you submit it, too.

All Swing homeworks are individual. Group work is not permitted.
