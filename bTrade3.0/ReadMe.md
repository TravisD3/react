Admin Page - Ssuyu Liu

- Fixed Modify button -    
   - Import AdminUserEditComponent in app.module.ts 
   - Modified server codes to encode modified password 

- Fixed Submit button on Add User - 
   - Added 2 more rows, email and name 
   - Modified server codes to encode password 
   - Set role to new adding users, currently they are 'users' 

- Fixed three button labels on the main Admin page -
   - Modified admin.component.css file
   - Modified admin.component.html file: add "btn btn-primary d-flex justify-content-center d-md-table mx-auto" in mat-raised-button class

- Next step -
   - Modifying admin-user-component.html and admin-user-component.css to fix 2 colomns responsive 
   - Modifying above 2 files to make UserList a responsive table
   - Try to use React to rewrite Front Application